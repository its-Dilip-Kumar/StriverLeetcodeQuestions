class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        List<List<Integer>> ans=new ArrayList<>();
        int num=(1<<n)-1;
        for(int i=0;i<=num;i++){
            List<Integer> temp=new ArrayList<>();
            for(int j=0;j<nums.length;j++){
                if((i&(1<<j))!=0){
                    temp.add(nums[j]);
                }
            }
            ans.add(new ArrayList<>(temp));
        }
        return ans;
    }
}