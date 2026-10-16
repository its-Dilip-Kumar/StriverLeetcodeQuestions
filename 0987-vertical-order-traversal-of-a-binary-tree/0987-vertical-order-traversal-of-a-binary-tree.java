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
    class Pair{
        TreeNode node;
        int level;
        int hd;
        public Pair(TreeNode node,int level,int hd){
            this.node=node;
            this.level=level;
            this.hd=hd;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        TreeMap<Integer,TreeMap<Integer,List<Integer>>> nodes=new TreeMap<>();
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0,0));

        while(!q.isEmpty()){
            Pair curr=q.remove();
            TreeNode node=curr.node;
            int level=curr.level;
            int hd=curr.hd;

            nodes.putIfAbsent(hd,new TreeMap<>());
            nodes.get(hd).putIfAbsent(level,new ArrayList<>());
            nodes.get(hd).get(level).add(node.val);

            if(node.left!=null){
                q.add(new Pair(node.left,level+1,hd-1));
            }
            if(node.right!=null){
                q.add(new Pair(node.right,level+1,hd+1));
            }
        }


        for(TreeMap<Integer,List<Integer>> levelMap:nodes.values()){
            List<Integer> column=new ArrayList<>();
            for(List<Integer> list:levelMap.values()){
                Collections.sort(list);
                column.addAll(list);
            }
            ans.add(column);
        }

        return ans;

    }
}