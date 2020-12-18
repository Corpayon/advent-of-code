package Day_12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.lang.Integer.parseInt;


public class AdventOfCode_12 {

    public static void main(String[] args) throws IOException {

        part1();
    }

    public static void part1() throws FileNotFoundException {

        Scanner scan;
        String current_Direction = "E";

        Map<String, Integer> mapResult = Stream.of(new Object[][]{
                {"E", 0}, {"W", 0}, {"S", 0}, {"N", 0}
        }).collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));

        ArrayList<String> list = new ArrayList<>(Arrays.asList("E", "S", "W", "N"));
        Map<String, Integer> directions = Stream.of(new Object[][]{
                {"R90", 1}, {"R180", 2}, {"R270", 3}, {"L90", 3}, {"L180", 2}, {"L270", 1}
        }).collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));

        scan = new Scanner(new File("C:\\Users\\Megaport\\Desktop\\Sachen\\Advent of Code\\src\\Day_12\\text"));

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

    public static void part2(){
        System.out.println();

    }
}
