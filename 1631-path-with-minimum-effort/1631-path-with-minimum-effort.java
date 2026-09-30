class Pair{
    int distance;
    int row;
    int col;
    public Pair(int distance,int row,int col){
        this.distance=distance;
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;

        if(n==0 && m==0) return 0;

        int[][] dist=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }

        dist[0][0]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.distance-b.distance);
        pq.add(new Pair(0,0,0));

        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};

        while(!pq.isEmpty()){
            Pair node=pq.remove();
            int diff=node.distance;
            int r=node.row;
            int c=node.col;

            if(r==n-1 && c==m-1) return diff;

            for(int i=0;i<4;i++){
                int delrow=r+dr[i];
                int delcol=c+dc[i];

                if(delrow>=0 && delrow<n && delcol>=0 && delcol<m){
                    int newEffort=Math.max(Math.abs(heights[delrow][delcol]-heights[r][c]),diff);
                    if(newEffort<dist[delrow][delcol]){
                        dist[delrow][delcol]=newEffort;
                        pq.add(new Pair(newEffort,delrow,delcol));
                    }
                }
            }
        }

        return -1;
    }
}