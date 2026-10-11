class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] dp=new int[n][m];
        for(int j=0;j<m;j++){
            dp[n-1][j]=matrix[n-1][j];
        }

        for(int i=n-2;i>=0;i--){
            for(int j=0;j<m;j++){
                int left=(j==0) ? Integer.MAX_VALUE : dp[i+1][j-1];
                int mid=dp[i+1][j];
                int right=(j==m-1) ? Integer.MAX_VALUE : dp[i+1][j+1];

                dp[i][j]=matrix[i][j]+Math.min(left,Math.min(mid,right));
            }
        }

        int min=Integer.MAX_VALUE;
        for(int j=0;j<m;j++){
            min=Math.min(min,dp[0][j]);
        }
        return min;
    }
}