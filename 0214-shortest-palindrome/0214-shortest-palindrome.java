class Solution {
    public static int[] findlps(String str){
        int n=str.length();
        int pre=0;
        int suff=1;
        int[] lps=new int[n];
        while(suff<n){
            if(str.charAt(pre)==str.charAt(suff)){
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
        return lps;
    }
    public String shortestPalindrome(String s) {
        String rev=new StringBuilder(s).reverse().toString();
        String newStr=s+"#"+rev;
        int[] lps=findlps(newStr);
        String str=s.substring(lps[newStr.length()-1]);
        String sb=new StringBuilder(str).reverse().toString();
        return sb+s;


    }
}