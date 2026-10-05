class Solution {
    public static long isPossible(int[] piles,int mid){
        long sum=0;
        for(int i=0;i<piles.length;i++){
            sum+=(piles[i]+mid-1)/mid;
        }
        return sum;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int start=1;
        int end=Integer.MIN_VALUE;
        for(int num:piles){
            end=Math.max(end,num);
        }
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            long result=isPossible(piles,mid);
            if(result<=h){
                ans=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return ans;
    }
}