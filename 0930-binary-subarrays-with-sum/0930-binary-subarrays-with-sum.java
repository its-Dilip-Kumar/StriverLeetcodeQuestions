class Solution {
    public static int solve(int[] nums,int goal){
        int n=nums.length;
        if(goal<0) return 0;
        int left=0;
        int right=0;
        int sum=0;
        int count=0;
        while(right<n){
            sum+=nums[right];
            while(sum>goal){
                sum-=nums[left];
                left++;
            }
            count+=(right-left+1);
            right++;
        }
        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n=nums.length;
        return solve(nums,goal)-solve(nums,goal-1);
    }
}