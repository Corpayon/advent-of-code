package Day_12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.lang.Integer.parseInt;


public class AdventOfCode_12 {

    public static void main(String[] args) throws IOException {

        //   part1();
        part2();
    }

    public static void part1() throws FileNotFoundException {

        Scanner scan = new Scanner(new File("C:\\Users\\Megaport\\Desktop\\Sachen\\Advent of Code\\src\\Day_12\\text"));
        String current_Direction = "E";

        Map<String, Integer> mapResult = Stream.of(new Object[][]{
                {"E", 0}, {"W", 0}, {"S", 0}, {"N", 0}
        }).collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));

        ArrayList<String> list = new ArrayList<>(Arrays.asList("E", "S", "W", "N"));
        Map<String, Integer> directions = Stream.of(new Object[][]{
                {"R90", 1}, {"R180", 2}, {"R270", 3}, {"L90", 3}, {"L180", 2}, {"L270", 1}
        }).collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));

        while (scan.hasNext()) {
            String z = scan.nextLine();
            int value = parseInt(z.substring(1));
            String command = z.substring(0, 1);
            if (z.contains("L") || z.contains("R")) {
                for (String s : directions.keySet()) {
                    if (s.equals(z)) {
                        current_Direction = list.get((list.indexOf(current_Direction) + directions.get(s)) % 4);
                    }
                }
            } else if (!(z.contains("F"))) {
                mapResult.replace(command, mapResult.get(command) + value);
            } else {
                mapResult.replace(current_Direction, mapResult.get(current_Direction) + value);
            }

        }
        System.out.println(Math.abs(mapResult.get("E") - mapResult.get("W")) + Math.abs(mapResult.get("N") - mapResult.get("S")));
    }

    //89984
    public static void part2() throws IOException {

        Scanner scan = new Scanner(new File("C:\\Users\\Megaport\\Desktop\\Sachen\\Advent of Code\\src\\Day_12\\text"));
        //                  O S W N
        int[] waypoint = {10, 0, 0, 1};
        int[] safeAll = {0, 0, 0, 0};
        int x = 0;
        int y = 3;
        int x_2 = 2;
        int y_2 = 1;


        Map<String, Integer> directions = Stream.of(new Object[][]{
                {"R90", 1}, {"R180", 2}, {"R270", 3}, {"L90", 3}, {"L180", 2}, {"L270", 1}
        }).collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));

        while (scan.hasNext()) {
            String z = scan.nextLine();
            int value = parseInt(z.substring(1));
            String command = z.substring(0, 1);
            if (command.equals("F")) {

                safeAll[x] += (waypoint[x]) * value;
                safeAll[y] += (waypoint[y]) * value;


            } else if (command.equals("L") || command.equals("R")) {
                for (String s : directions.keySet()) {
                    if (s.equals(z)) {


                        int oldx = waypoint[x];
                        int oldy = waypoint[y];
                        int oldx2 = waypoint[x_2];
                        int oldy2 = waypoint[y_2];


                        x = (x + directions.get(s)) % 4;
                        y = (y + directions.get(s)) % 4;
                        x_2 = (x_2 + directions.get(s)) % 4;
                        y_2 = (y_2 + directions.get(s)) % 4;

                        waypoint = new int[4];

                        waypoint[x] = oldx;
                        waypoint[y] = oldy;
                        waypoint[x_2] = oldx2;
                        waypoint[y_2] = oldy2;

                    }
                }
            } else if (command.equals("N")) {
                waypoint[3] += value;

            } else if (command.equals("W")) {
                waypoint[2] += value;

            } else if (command.equals("S")) {
                waypoint[1] += value;

            } else if (command.equals("O")) {
                waypoint[0] += value;
            }

            for (int i = 0; i < waypoint.length; i++) {

                System.out.print(waypoint[i] + ",");
            }
            System.out.println("\n--------------------------");
        }


        for (int i = 0; i < safeAll.length; i++) {

            System.out.print(safeAll[i] + ",");
        }
        System.out.println("---------------\n");

        System.out.println(Math.abs(safeAll[0] - safeAll[2]) + Math.abs(safeAll[1] - safeAll[3]));

    }
}


