class Solution {
    public int[] singleNumber(int[] nums) {
        int n=nums.length;
        int xor=0;
        for(int x:nums){
            xor^=x;
        }

        int bit= xor & (-xor);

        int x=0,y=0;
        for(int v:nums){
            if((v & bit)!=0) x^=v;
            else y^=v;
        }

        return new int[]{x,y};
    }
}