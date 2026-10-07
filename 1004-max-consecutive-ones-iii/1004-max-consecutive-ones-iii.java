class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int left=0;
        int right=0;
        int zero=0;
        int maxlen=0;
        while(right<n){
            if(nums[right]==0) zero++;
            while(zero>k){
                if(nums[left]==0) zero--;
                left++;
            }
            maxlen=Math.max(maxlen,right-left+1);
            right++;
        }
        return maxlen;
    }
}