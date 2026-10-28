class Pair{
    int stops;
    int node;
    int weight;
    public Pair(int stops,int node,int weight){
        this.stops=stops;
        this.node=node;
        this.weight=weight;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge:flights){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            adj.get(u).add(new int[]{v,w});
        }

        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;

        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(0,src,0));
        
        while(!q.isEmpty()){
            Pair curr=q.remove();
            int stops=curr.stops;
            int node=curr.node;
            int cost=curr.weight;

            if(stops>k) continue;

            for(int[] neigbour:adj.get(node)){
                int v=neigbour[0];
                int wt=neigbour[1];

                if(cost+wt<dist[v]){
                    dist[v]=cost+wt;
                    q.add(new Pair(stops+1,v,dist[v]));
                }
            }
        }

        return dist[dst]==Integer.MAX_VALUE ? -1 : dist[dst];
    }
}