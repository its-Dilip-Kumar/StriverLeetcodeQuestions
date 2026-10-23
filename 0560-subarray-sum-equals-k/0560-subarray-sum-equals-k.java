class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int prefixsum=0;
        int count=0;

        for(int i=0;i<n;i++){
            prefixsum+=nums[i];
            if(map.containsKey(prefixsum-k)){
                count+=map.get(prefixsum-k);
            }
            if(map.containsKey(prefixsum)){
                map.put(prefixsum,map.get(prefixsum)+1);
            }else{
                map.put(prefixsum,1);
            }
        }
        return count;
    }
}