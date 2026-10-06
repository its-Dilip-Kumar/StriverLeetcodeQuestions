class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        int n=s.length();
        int sign=1;
        boolean ishandlesign=false;
        int ans=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(!ishandlesign && (ch=='+' || ch=='-')){
                sign=(ch=='+') ? 1 : -1;
                ishandlesign=true;
                continue; 
            }

            if(!Character.isDigit(ch)){
                break;
            }

            int digit=ch-'0';
            if(ans>(Integer.MAX_VALUE-digit)/10){
                return sign==1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans=ans*10+digit;
            ishandlesign=true;
        }
        return ans*sign;
    }
}