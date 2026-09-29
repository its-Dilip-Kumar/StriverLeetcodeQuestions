/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int maxsum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxsum;
    }
    private int helper(TreeNode root){
        if(root==null) return 0;
        int lsum=Math.max(0,helper(root.left));
        int rsum=Math.max(0,helper(root.right));
        maxsum=Math.max(maxsum,lsum+rsum+root.val);
        return root.val+Math.max(lsum,rsum);
    }
}