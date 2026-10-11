class Solution {

    public static int solve(int row, int col1, int col2, int[][] grid,int[][][] dp) {
        int n = grid.length;
        int m = grid[0].length;

        // Out of bounds
        if (col1 < 0 || col1 >= m || col2 < 0 || col2 >= m) return Integer.MIN_VALUE;

        // Base case: last row
        if (row == n - 1) {
            if (col1 == col2) return grid[row][col1];
            return grid[row][col1] + grid[row][col2];
        }

        if(dp[row][col1][col2]!=-1)return dp[row][col1][col2];
        // Current cherries
        int cherries = (col1 == col2) ? grid[row][col1] : grid[row][col1] + grid[row][col2];

        // 9 combinations try karo
        int maxCherries = Integer.MIN_VALUE;
        for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 = -1; d2 <= 1; d2++) {
                int next = solve(row + 1, col1 + d1, col2 + d2, grid,dp);
                maxCherries = Math.max(maxCherries, next);
            }
        }

        return dp[row][col1][col2]=cherries + maxCherries;
    }

    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        int m = grid[0].length;
        int[][][] dp=new int[n][m][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return solve(0, 0, m - 1, grid,dp);
    }
}