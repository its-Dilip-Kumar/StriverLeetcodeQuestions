class Solution {
    public static boolean validate(int row,int col,char[][] chessboard){
        for(int i=0;i<row;i++){
            if(chessboard[i][col]=='Q'){
                return false;
            }
        }

        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(chessboard[i][j]=='Q'){
                return false;
            }
        }

        for(int i=row-1,j=col+1;i>=0 && j<chessboard[0].length;i--,j++){
            if(chessboard[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }

    public static List<String> convertedboard(char[][] chessboard) {
        List<String> list = new ArrayList<>();
        for (char[] boardRow : chessboard) {
            list.add(new String(boardRow));
        }
        return list;
    }

    public static void solve(int row, char[][] chessboard, List<List<String>> ans) {
        if (row >= chessboard.length) {
            ans.add(convertedboard(chessboard));
            return;
        }
        for (int col = 0; col < chessboard[0].length; col++) {
            if (validate(row, col, chessboard)) {
                chessboard[row][col] = 'Q';
                solve(row + 1, chessboard, ans);
                chessboard[row][col] = '.';
            }

        }
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chessboard[i][j] = '.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        solve(0, chessboard, ans);
        return ans;
    }
}