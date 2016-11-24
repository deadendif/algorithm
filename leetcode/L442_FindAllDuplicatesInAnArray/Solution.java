package leetcode.L442_FindAllDuplicatesInAnArray;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author: deadend
 * @date: 3:57 PM 11/23/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] - 1 != i) {
                if (nums[nums[i] - 1] == nums[i]) {
                    break;
                }
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                result.add(nums[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,2,3,1};
        System.out.println(new Solution().findDuplicates(nums));
    }
}
