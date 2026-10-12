class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length;
        int xor=0;
        for(int num:nums){
            xor^=num;
        }
        return xor;
    }
}