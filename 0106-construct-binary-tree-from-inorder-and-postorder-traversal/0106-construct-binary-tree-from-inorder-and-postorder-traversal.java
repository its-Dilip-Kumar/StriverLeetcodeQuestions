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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=inorder.length;
        int[] postIdx={n-1};
        return solve(inorder,postorder,postIdx,0,n-1);
    }
    public static TreeNode solve(int[] inorder,int[] postorder,int[] postIdx,int start,int end){
        if(start>end) return null;
        int element=postorder[postIdx[0]--];
        TreeNode root=new TreeNode(element);
        int idx=findIdx(element,inorder,start,end);
        root.right=solve(inorder,postorder,postIdx,idx+1,end);
        root.left=solve(inorder,postorder,postIdx,start,idx-1);
        return root;
    }
    public static int findIdx(int element,int[] inorder,int start,int end){
        for(int i=start;i<=end;i++){
            if(inorder[i]==element){
                return i;
            }
        }
        return -1;
    }
}