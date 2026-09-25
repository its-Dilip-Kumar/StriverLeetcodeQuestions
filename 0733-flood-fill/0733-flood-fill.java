class Pair{
    int row;
    int col;
    public Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}

class Solution {
    public static void bfs(int sr,int sc,Queue<Pair> q,int[][] result,int[][] image,int color){

        int n=image.length;
        int m=image[0].length;
        q.add(new Pair(sr,sc));
        result[sr][sc]=color;

        while(!q.isEmpty()){
            Pair node=q.remove();
            int r=node.row;
            int c=node.col;

            int[] dr={-1,1,0,0};
            int[] dc={0,0,-1,1};

            for(int i=0;i<4;i++){
                int delrow=r+dr[i];
                int delcol=c+dc[i];

                if(delrow>=0 && delrow<n && delcol>=0 && delcol<m && result[delrow][delcol]==image[sr][sc]){
                    q.add(new Pair(delrow,delcol));
                    result[delrow][delcol]=color;
                }
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        if(image[sr][sc]==color) return image;
        Queue<Pair> q=new LinkedList<>();
        int[][] result=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                result[i][j]=image[i][j];
            }
        }

        bfs(sr,sc,q,result,image,color);
        return result;
        


    }
}