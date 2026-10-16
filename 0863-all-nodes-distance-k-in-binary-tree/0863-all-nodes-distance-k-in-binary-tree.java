/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public static void inorder(TreeNode root,HashMap<TreeNode,TreeNode> map){
        if(root==null) return;
        if(root.left!=null){
            map.put(root.left,root);
            inorder(root.left,map);
        }
        if(root.right!=null){
            map.put(root.right,root);
            inorder(root.right,map);
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        HashMap<TreeNode,TreeNode> map=new HashMap<>();
        HashSet<TreeNode> visited=new HashSet<>();
        inorder(root,map);
        Queue<TreeNode> q=new LinkedList<>();
        q.add(target);
        visited.add(target);

        int count=0;
        while(!q.isEmpty()){
            if(count==k) break;
            int n=q.size();
            
            while(n-->0){
                TreeNode curr=q.remove();
                if(curr.left!=null && !visited.contains(curr.left)){
                    q.add(curr.left);
                    visited.add(curr.left);
                }
                if(curr.right!=null && !visited.contains(curr.right)){
                    q.add(curr.right);
                    visited.add(curr.right);
                }
                TreeNode parent=map.get(curr);
                if(parent!=null && !visited.contains(parent)){
                    q.add(parent);
                    visited.add(parent);
                }
            }
            count++;
        }

        while(!q.isEmpty()){
            ans.add(q.remove().val);
        }
        return ans;

    }
}