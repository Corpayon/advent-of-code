package Day_01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class AdventofCode_01 {

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> array2 = new ArrayList<>();
        File file = new File("C:\\Users\\Megaport\\Desktop\\Sachen\\Advent of Code\\src\\Day_01\\text");
        BufferedReader in;

        in = new BufferedReader(new FileReader(file));
        String zeile;
        while ((zeile = in.readLine()) != null) {
            array2.add(Integer.valueOf(zeile));
        }

        Collections.sort(array2);

        int result = 0;

        for (int i = 0; i < array2.size(); i++) {
            for (int j = i; j < array2.size() - 1; j++) {
                for (int k = j; k < array2.size() - 2; k++) {
                    int one = array2.get(i);
                    int two = array2.get(j + 1);
                    int three = array2.get((k+2));

                    if (one + two + three == 2020) {
                        result = one * two * three;
                    }
                }
            }

        }
        System.out.println(result);
    }

}
