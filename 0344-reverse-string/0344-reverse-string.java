class Solution {
    public static void reverse(char[] s, int i){
        if(i>=s.length/2) return;
        char temp=s[s.length-i-1];
        s[s.length-i-1]=s[i];
        s[i]=temp;
        reverse(s,i+1);
    }
    public void reverseString(char[] s) {
        reverse(s,0);
    }
}