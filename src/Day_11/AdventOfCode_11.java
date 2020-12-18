package Day_11;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class AdventOfCode_11 {

    static int row;
    static int coloum;
    static char[][] arrayOld;
    static char[][] arrayNew;


    public static void main(String[] args) throws IOException {

        //String text = Files.readString(Paths.get("C:\\Users\\Megaport\\Desktop\\Sachen\\Advent of Code\\src\\Day_11\\text"));
        arrayOld = Files.lines(Paths.get("C:\\Users\\Megaport\\Desktop\\Sachen\\Advent of Code\\src\\Day_11\\text"))
                .map(String::toCharArray)
                .toArray(char[][]::new);

        row = arrayOld.length;
        coloum = arrayOld[1].length;

        while (true) {
            arrayNew = new char[coloum][row];

            for (int i = 0; i < coloum; i++) {
                for (int j = 0; j < row; j++) {
                    if (arrayOld[i][j] == '.') {
                        arrayNew[i][j] = '.';
                        continue;
                    }
                    int sum = checkNeighbours(i, j);

                    if (sum == 0) {
                        arrayNew[i][j] = '#';
                    } else if (sum >= 4 && arrayOld[i][j] == '#') {
                        arrayNew[i][j] = 'L';
                    } else {
                        arrayNew[i][j] = arrayOld[i][j];

                    }
                }
            }
            if (Arrays.deepEquals(arrayNew, arrayOld)) {
                System.out.println(countRaute(arrayNew));
                break;
            }
            arrayOld = arrayNew;
        }
    }

    public static int countRaute(char[][] arrayNew) {
        int result = 0;
        for (int i = 0; i < coloum; i++) {
            for (int j = 0; j < row; j++) {
                if (arrayNew[i][j] == '#') {
                    result++;
                }
            }
        }
        return result;
    }


    public static int checkNeighbours(int i, int j) {
        int sum = 0;
        sum += i - 1 >= 0 && arrayOld[i - 1][j] == '#' ? 1 : 0;
        sum += i - 1 >= 0 && j + 1 < row && arrayOld[i - 1][j + 1] == '#' ? 1 : 0;
        sum += j + 1 < row && arrayOld[i][j + 1] == '#' ? 1 : 0;
        sum += i + 1 < coloum && j + 1 < row && arrayOld[i + 1][j + 1] == '#' ? 1 : 0;
        sum += i + 1 < coloum && arrayOld[i + 1][j] == '#' ? 1 : 0;
        sum += i + 1 < coloum && j - 1 >= 0 && arrayOld[i + 1][j - 1] == '#' ? 1 : 0;
        sum += j - 1 >= 0 && arrayOld[i][j - 1] == '#' ? 1 : 0;
        sum += i - 1 >= 0 && j - 1 >= 0 && arrayOld[i - 1][j - 1] == '#' ? 1 : 0;
        return sum;
    }

}




