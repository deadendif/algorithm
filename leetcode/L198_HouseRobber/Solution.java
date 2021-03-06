package leetcode.L198_HouseRobber;


public class Solution {
    public int rob(int[] nums) {
        final int n = nums.length;
        int[] f = new int[2];
        for (int i = 1; i <= n; i++) {
            f[i % 2] = Math.max(f[i % 2] + nums[i], f[1 - i % 2]);
        }
        return f[n % 2];
    }
}


class BasicSolution {
    public int rob(int[] nums) {
        final int n = nums.length;
        int[][] f = new int[2][2];
        for (int i = 1; i <= n; i++) {
            f[i % 2][1] = f[(i - 1) % 2][0] + nums[i - 1];
            f[i % 2][0] = Math.max(f[(i - 1) % 2][0], f[(i - 1) % 2][1]);
        }

        return Math.max(f[n % 2][0], f[n % 2][1]);
    }
}

