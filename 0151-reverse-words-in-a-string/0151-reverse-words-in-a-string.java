class Solution {
    public String reverseWords(String s) {
        int n=s.length();
        StringBuilder ans=new StringBuilder();
        StringBuilder temp=new StringBuilder();
        for(int i=n-1;i>=0;i--){
            char ch=s.charAt(i);
            if(ch!=' '){
                temp.append(ch);
            }else{
                while(i>=0 && s.charAt(i)==' '){
                    i--;
                }
                if(temp.length()>0){
                    temp.reverse();
                    ans.append(temp);
                    ans.append(" ");
                    temp.setLength(0);
                }
                i++;
            }
        }
        if(temp.length()>0){
            temp.reverse();
            ans.append(temp);
            temp.setLength(0);
        }
        return ans.toString().trim();
    }
}