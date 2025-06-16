import java.util.Arrays;
import java.util.Scanner;

public class check {
    public static void main(String arg[]) {
        Scanner x = new Scanner(System.in);
        char[][] arr = new char[2][6];
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                arr[i][j] = x.next().charAt(0);
            }
        }
        System.out.println(Arrays.deepToString(arr));
        x.close();
    }
}
