class Solution {
    public boolean checkValidString(String s) {
        int n=s.length();
        int low=0;
        int high=0;
        int i=0;
        while(i<n){
            char ch=s.charAt(i);
            if(ch=='('){
                low++;
                high++;
            }else if(ch==')'){
                if(low>0) low--;
                high--;
            }else{
                if(low>0) low--;
                high++;
            }
            if(high<0) return false;
            i++;
        }
        return low==0;
    }
}