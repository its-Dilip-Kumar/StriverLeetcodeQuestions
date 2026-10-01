class Solution {
    public String longestPrefix(String s) {
        int n=s.length();
        int[] lps=new int[n];
        int pre=0;
        int suff=1;
        while(suff<n){
            if(s.charAt(suff)==s.charAt(pre)){
                pre++;
                lps[suff]=pre;
                suff++;
            }else if(pre==0){
                lps[suff]=pre;
                suff++;
            }else{
                pre=lps[pre-1];
            }
        }
        return s.substring(0,lps[n-1]);
    }
}