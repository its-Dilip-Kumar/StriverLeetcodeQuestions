class Solution {
    public static boolean solve(int idx,int[] nums,int target,int sum,Boolean[][] dp){
        if(sum==target) return true;
        if(idx<0 || sum>target) return false;
        if(dp[idx][sum]!=null) return dp[idx][sum];
        boolean take=solve(idx-1,nums,target,sum+nums[idx],dp);
        boolean notake=solve(idx-1,nums,target,sum,dp);
        return dp[idx][sum]=take || notake;
    }
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        if(sum%2!=0) return false;
        int target=sum/2;
        Boolean[][] dp=new Boolean[n][target+1];
        return solve(n-1,nums,target,0,dp);
    }
}