class Solution {
    public int[] rearrangeArray(int[] nums) {
        ArrayList<Integer> list1=new ArrayList<>();
        ArrayList<Integer> list2=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                list1.add(nums[i]);
            }else{
                list2.add(nums[i]);
            }
        }

        int[] ans=new int[n];
        for(int i=0;i<n/2;i++){
            ans[2*i]=list1.get(i);
            ans[2*i+1]=list2.get(i);
        }
        return ans;
    }
}