class Solution {
    public static int solve(int idx,int[] nums,int prevIdx,int[][] dp){
        if(idx>=nums.length) return 0;
        if(dp[idx][prevIdx+1]!=-1) return dp[idx][prevIdx+1];
        int maxlen=solve(idx+1,nums,prevIdx,dp);
        if(prevIdx==-1 || nums[idx]>nums[prevIdx]){
            maxlen=Math.max(maxlen,1+solve(idx+1,nums,idx,dp));
        }
        return dp[idx][prevIdx+1]=maxlen;
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n][n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        return solve(0,nums,-1,dp);
    }
}