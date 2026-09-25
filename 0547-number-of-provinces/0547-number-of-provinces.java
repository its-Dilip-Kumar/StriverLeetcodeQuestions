class Solution {
    public static void bfs(int start,Queue<Integer> q,boolean[] visited,int[][] arr){
        q.add(start);
        visited[start]=true;
        while(!q.isEmpty()){
            int node=q.remove();
            for(int i=0;i<arr[node].length;i++){
                if(arr[node][i]==1 && !visited[i]){
                    visited[i]=true;
                    q.add(i);
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int V=isConnected.length;
        Queue<Integer> q=new LinkedList<>();
        boolean[] visited=new boolean[V];
        int count=0;
        for(int i=0;i<V;i++){
            if(!visited[i]){
                count++;
                bfs(i,q,visited,isConnected);
            }
        }
        return count;
    }
}