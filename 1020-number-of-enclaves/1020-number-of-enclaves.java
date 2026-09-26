class Pair {
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] visited=new int[n][m];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    if(grid[i][j]==1){
                        q.add(new Pair(i,j));
                        visited[i][j]=1;
                    }
                }
            }
        }

        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};

        while(!q.isEmpty()){
            Pair node = q.remove();
            int r=node.row;
            int c=node.col;

            for(int i=0;i<4;i++){
                int delrow=r+dr[i];
                int delcol=c+dc[i];
                if(delrow>=0 && delrow<n && delcol>=0 && delcol<m && grid[delrow][delcol]==1 && visited[delrow][delcol]==0){
                    q.add(new Pair(delrow,delcol));
                    visited[delrow][delcol]=1;
                }
            }
        }

            int count=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(grid[i][j]==1 && visited[i][j]==0){
                        count++;
                    }
                }
            }
            return count;
    }
}