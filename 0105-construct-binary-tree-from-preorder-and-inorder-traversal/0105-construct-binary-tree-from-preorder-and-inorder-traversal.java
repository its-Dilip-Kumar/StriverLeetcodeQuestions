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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=inorder.length;
        int[] preIdx={0};
        return solve(preorder,inorder,preIdx,0,n-1);
    }
    public static TreeNode solve(int[] preorder,int[] inorder,int[] preIdx,int start,int end){
        if(start>end) return null;
        int element=preorder[preIdx[0]++];
        TreeNode root=new TreeNode(element);
        int idx=findIdx(element,inorder,start,end);
        root.left=solve(preorder,inorder,preIdx,start,idx-1);
        root.right=solve(preorder,inorder,preIdx,idx+1,end);
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