import java.util.Arrays;

public class staticRangeSumQueries {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 8, 6, 9, 2, 1, 7};
        //           0  1  2  3  4  5  6  7  8  9
        double chunk = Math.sqrt(arr.length);
        int[] newArr = new int[(int)(chunk + 1)];

        // int idx = 0, i = 0, j = 0, count = 0, sum = 0;
        // while (j < arr.length) {
        //     sum += arr[i];
        //     count++;
        //     if(count == chunk) {
        //         newArr[idx++] = sum;
        //         sum = 0;
        //         count = 0;
        //         i = j + 1;
        //     }
        //     j++;
        // }

        for(int i = 0; i < arr.length; i++) {
            newArr[i / (int)chunk] += arr[i];
        }
        System.out.println(Arrays.toString(newArr));
    }
}
