class Pair{
    int node;
    int color;
    public Pair(int node,int color){
        this.node=node;
        this.color=color;
    }
}
class Solution {
    public static boolean isBfs(int sr,int color,Queue<Pair> q,int[] visited,int[][] graph){
        q.add(new Pair(sr,color));
        visited[sr]=color;

        while(!q.isEmpty()){
            Pair node=q.remove();
            int childNode=node.node;
            int childColor=node.color;

            for(int it:graph[childNode]){
                if(visited[it]==-1){
                    q.add(new Pair(it,1-childColor));
                    visited[it]=1-childColor;
                }else if(visited[it]==childColor){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int m=graph[0].length;
        Queue<Pair> q=new LinkedList<>();
        int[] visited=new int[n];
        Arrays.fill(visited,-1);
        for(int i=0;i<n;i++){
            if(visited[i]==-1){
                if(!isBfs(i,0,q,visited,graph)) return false;
            }
        }
        return true;
    }

}