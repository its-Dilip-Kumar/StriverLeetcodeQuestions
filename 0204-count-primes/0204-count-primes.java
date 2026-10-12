class Solution {
    public int countPrimes(int n) {
        int[] prime=new int[n+1];
        Arrays.fill(prime,1);
        for(int i=2;i*i<n;i++){
            if(prime[i]==1){
                for(int j=i*i;j<n;j+=i){
                    prime[i]=0;
                }
            }
        }

        int ans=0;
        for(int i=2;i<n;i++){
            if(prime[i]==1){
                ans++;
            }
        }
        return ans;
    }
}