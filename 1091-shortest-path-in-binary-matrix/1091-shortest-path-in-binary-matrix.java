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
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        if(grid[0][0]==1) return -1;

        int[][] dist=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(0,0,0));
        dist[0][0]=0;

        int[] dr = {-1, -1, -1,  0, 0,  1, 1, 1};
        int[] dc = {-1,  0,  1, -1, 1, -1, 0, 1};

        while(!q.isEmpty()){
            Pair node=q.remove();
            int d=node.distance;
            int r=node.row;
            int c=node.col;

            for(int i=0;i<8;i++){
                int delrow=r+dr[i];
                int delcol=c+dc[i];
                if(delrow>=0 && delrow<n && delcol>=0 && delcol<m && grid[delrow][delcol]==0){
                    if(d+1<dist[delrow][delcol]){
                        dist[delrow][delcol]=d+1;
                        q.add(new Pair(d+1,delrow,delcol));
                    }
                }
            }
        }
        if(dist[n-1][m-1]==Integer.MAX_VALUE) return -1;
        return dist[n-1][m-1]+1;
    }
}