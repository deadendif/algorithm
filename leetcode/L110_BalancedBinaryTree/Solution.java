package leetcode.L110_BalancedBinaryTree;

/**
 * @author: deadend
 * @date: P10:06 PM 12/3/16
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

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = depth(root.left);
        int r = depth(root.right);
        if (l == -1 || r == -1)
            return -1;

        return Math.abs(r - l) <= 1 ? Math.max(l, r) + 1 : -1;
    }

    public boolean isBalanced(TreeNode root) {
        return depth(root) >= 0;
    }
}

class OldSolution {
    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = -1, rightDepth = -1;
        if ((leftDepth = getDepth(root.left)) == -1 || (rightDepth = getDepth(root.right)) == -1) {
            return -1;
        }

        return Math.abs(leftDepth - rightDepth) > 1 ? -1 : Math.max(leftDepth, rightDepth) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        return getDepth(root) != -1;
    }
}
