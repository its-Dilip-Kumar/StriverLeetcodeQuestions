class Pair{
    int row;
    int col;
    int time;
    public Pair(int row,int col,int time){
        this.row=row;
        this.col=col;
        this.time=time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        int[][] visited=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    visited[i][j]=2;
                }else if(grid[i][j]==1){
                    visited[i][j]=1;
                }
            }
        }

        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};

        int tm=0;
        while(!q.isEmpty()){
            Pair node=q.remove();
            int r=node.row;
            int c=node.col;
            int t=node.time;

            tm=Math.max(tm,t);
            for(int i=0;i<4;i++){
                int delrow=r+dr[i];
                int delcol=c+dc[i];

                if(delrow>=0 && delrow<n && delcol>=0 && delcol<m && grid[delrow][delcol]==1 && visited[delrow][delcol]!=2){
                    q.add(new Pair(delrow,delcol,t+1));
                    visited[delrow][delcol]=2;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==1) return -1;
            }
        }
        return tm;
    }
}