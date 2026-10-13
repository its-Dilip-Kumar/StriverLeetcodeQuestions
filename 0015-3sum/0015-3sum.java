class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        HashSet<List<Integer>> ans=new HashSet<>();
        for(int i=0;i<n;i++){
            HashSet<Integer> map=new HashSet<>();
            for(int j=i+1;j<n;j++){
                int target=-(nums[i]+nums[j]);
                if(map.contains(target)){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(target);
                    Collections.sort(temp);
                    ans.add(temp);
                }
                map.add(nums[j]);
            }
        }
        return new ArrayList<>(ans); 
    }
}