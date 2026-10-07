class Solution {
    public int minBitFlips(int start, int goal) {
        int xor=start^goal;
        return solve(xor);
    }
    public static int solve(int n){
        int count=0;
        while(n!=0){
            if((n&1)==1) count++;
            n=n>>1;
        }
        return count;
    }
}