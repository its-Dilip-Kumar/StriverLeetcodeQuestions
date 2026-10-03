class Solution {
    public String removeOuterParentheses(String s) {
        int n=s.length();
        String ans="";
        int count=0;
        int start=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                count++;
            }else{
                count--;
                if(count==0){
                    ans+=s.substring(start+1,i);
                    start=i+1;
                }
            }
        }
        return ans;
    }
}