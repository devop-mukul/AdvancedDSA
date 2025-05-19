
import java.util.Arrays;

public class canJump {
    // public boolean canJump(int[] nums) {
    //     int n = nums.length;
    //     boolean[] dp = new boolean[n];
    //     Arrays.fill(dp, false);
    //     dp[n - 1] = true;  // Base case set after filling

    //     for (int i = n - 2; i >= 0; i--) {
    //         for (int j = 1; j <= nums[i]; j++) {
    //             if (i + j < n && dp[i + j]) {
    //                 dp[i] = true;
    //                 break;  // No need to check further jumps
    //             }
    //         }
    //     }

    //     return dp[0];
    // }

    //    Greedy Solution
    public static boolean canJump(int[] nums){

        int maxReach = 0;

        for (int i = 0; i < nums.length; i++){
            if (i > maxReach) return false;
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= nums.length - 1) return true;
        }

        return true;
    }

    public static void main(String[] args) {
        canJump cnj = new canJump();
        int[] nums = {2,3,1,1,4};
        System.out.println(cnj.canJump(nums));
    }
}