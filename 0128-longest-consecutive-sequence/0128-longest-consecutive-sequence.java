class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs=new HashSet<>();
        for(int num:nums){
            hs.add(num);
        }

        int longest=0;
        for(int x:hs){
            if(!hs.contains(x-1)){
                int num=x;
                int streak=1;
                while(hs.contains(num+1)){
                    num=num+1;
                    streak++;
                }
                longest=Math.max(longest,streak);
            }
        }
        return longest;
    }
}