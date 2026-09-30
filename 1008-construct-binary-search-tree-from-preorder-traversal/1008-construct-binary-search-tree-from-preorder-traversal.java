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
    public static int findIdx(int[] inorder,int element,int start,int end){
        for(int i=start;i<=end;i++){
            if(inorder[i]==element){
                return i;
            }
        }
        return -1;
    }
    public static TreeNode solve(int[] preorder,int[] inorder,int[] preIdx,int start,int end){
        if(start>end) return null;
        int element=preorder[preIdx[0]++];
        TreeNode root=new TreeNode(element);
        int idx=findIdx(inorder,element,start,end);
        root.left=solve(preorder,inorder,preIdx,start,idx-1);
        root.right=solve(preorder,inorder,preIdx,idx+1,end);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int n=preorder.length;
        int[] inorder=Arrays.copyOf(preorder,n);
        Arrays.sort(inorder);
        int[] preIdx={0};
        return solve(preorder,inorder,preIdx,0,n-1);
    }
}