package leetcode.again.L124_BinaryTreeMaximumPathSum;

/**
 * @author: deadend
 * @date: P10:48 PM 3/3/17
 * @version: 1.0
 * @description:
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class Solution {
    private int max = Integer.MIN_VALUE;

    private int postorder(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lmax = Math.max(0, postorder(root.left));
        int rmax = Math.max(0, postorder(root.right));

        max = Math.max(max, lmax + rmax + root.val);
        return Math.max(lmax, rmax) + root.val;
    }

    public int maxPathSum(TreeNode root) {
        postorder(root);
        return max;
    }
}
