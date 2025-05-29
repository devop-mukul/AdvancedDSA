package DynamicProgramming;

import java.util.Arrays;

public class JumpGame2 {
    public int jump(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,  -1);
        return helper(nums, 0, dp);
    }
    public int helper(int nums[], int index, int dp[]) {
        if(index >= nums.length - 1) return 0;

        int res = nums.length;
        for(int j = 1; j <= nums[index]; j++) {
            if(index + j < nums.length)
                res = Math.min(res, 1 + helper(nums, index + j, dp));
        }
        System.out.println(Arrays.toString(dp));
        return dp[index] = res;
    }

    public static void main(String[] args) {
        JumpGame2 jumpGame2 = new JumpGame2();
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jumpGame2.jump(nums));
    }
}
