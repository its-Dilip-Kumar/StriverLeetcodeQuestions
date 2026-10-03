class Solution {
    public int maxDepth(String s) {
        int n=s.length();
        int count=0;
        int maxCount=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                count++;
            }else if(ch==')'){
                maxCount=Math.max(maxCount,count);
                count--;
            }
        }
        return maxCount;
    }
}