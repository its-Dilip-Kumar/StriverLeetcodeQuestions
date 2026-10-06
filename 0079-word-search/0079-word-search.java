class Solution {
    public static boolean solve(char[][] board,String word,int idx,int i,int j){
        if(idx>=word.length()){
            return true;
        }

        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]!=word.charAt(idx)) return false;

        char ch=board[i][j];
        board[i][j]='#';
        boolean found=solve(board,word,idx+1,i,j+1) ||
        solve(board,word,idx+1,i,j-1) ||
        solve(board,word,idx+1,i+1,j) || solve(board,word,idx+1,i-1,j);

        board[i][j]=ch;
        return found;

    }
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(solve(board,word,0,i,j)){
                    return true;
                }
            }
        }
        return false;
    }
}