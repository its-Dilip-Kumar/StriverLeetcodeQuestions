class Solution {
    public static double solve(double x,long n){
        if(n==0) return 1;
        if(n%2==0){
            return solve(x*x,n/2);
        }
        else{
            return x*solve(x,n-1);
        }
    }
    public double myPow(double x, int n) {
        if(n==0) return 1;
        long N=n;
        if(N<0){
            x=1/x;
            N=-N;
        }
        return solve(x,N);
    }
}