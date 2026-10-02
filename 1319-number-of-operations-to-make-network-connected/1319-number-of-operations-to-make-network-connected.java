class DisjointSet{
    public int[] parent;
    private int[] rank;
    private int[] size;

    public DisjointSet(int n){
        parent=new int[n+1];
        rank=new int[n+1];
        size=new int[n+1];

        for(int i=0;i<=n;i++){
            parent[i]=i;
            size[i]=1;
            rank[i]=0;
        }
    }

    public int pathCompression(int x){
        if(parent[x]!=x){
            parent[x]=pathCompression(parent[x]);
        }
        return parent[x];
    }

    public boolean find(int u,int v){
        return pathCompression(u)==pathCompression(v);
    }

    public void unionByRank(int u,int v){
        int rootU=pathCompression(u);
        int rootV=pathCompression(v);

        if(rootU==rootV) return ;

        if(rank[rootU]<rank[rootV]){
            parent[rootU]=rootV;
        }else if(rank[rootU]>rank[rootV]){
            parent[rootV]=rootU;
        }else{
            parent[rootV]=rootU;
            rank[rootU]++;
        }
    }

    public void unionBySize(int u,int v){
        int rootU=pathCompression(u);
        int rootV=pathCompression(v);

        if(rootU==rootV) return;

        if(size[rootU]<size[rootV]){
            parent[rootU]=rootV;
            size[rootV]+=size[rootU];
        }else{
            parent[rootV]=rootU;
            size[rootU] += size[rootV];
        }
    }

}
class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds=new DisjointSet(n);
        int m=connections.length;
        int cntExtra=0;
        for(int i=0;i<m;i++){
            int u=connections[i][0];
            int v=connections[i][1];
            if(ds.pathCompression(u)==ds.pathCompression(v)) cntExtra++;
            else ds.unionByRank(u,v);
        }

        int cntC=0;
        for(int i=0;i<n;i++){
            if(ds.parent[i]==i) cntC++;
        }
        int ans=cntC-1;
        if(cntExtra>=ans){
            return ans;
        }
        return -1;
    }
}