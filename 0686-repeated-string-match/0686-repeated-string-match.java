class Solution {
    public int repeatedStringMatch(String a, String b) {
        String ans="";
        int n=b.length();
        int count=0;
        while(ans.length()<n){
            ans+=a;
            count++;
        }
        if(ans.contains(b)){
            return count;
        }
        ans+=a;
        if(ans.contains(b)){
            return count+1;
        }
        return -1;
    }
}