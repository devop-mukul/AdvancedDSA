import java.util.ArrayList;
import java.util.List;


public class subSets78 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 8, 10, 12};
        System.out.println(subsets(nums));
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        for(int i = 0; i < (1 << n); i++) {
            List<Integer> subset = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                if((i & (1 << j)) != 0)
                    subset.add(nums[j]);
            }
            result.add(subset);
        }
        return result;
    }

}
