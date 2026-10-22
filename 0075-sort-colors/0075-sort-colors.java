class Solution {
    public static void swap(int i,int j,int[] nums){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void sortColors(int[] nums) {
        int n=nums.length;
        int left=0;
        int right=n-1;
        int mid=0;
        while(mid<=right){
            if(nums[mid]==0){
                swap(left,mid,nums);
                left++;
                mid++;
            }else if(nums[mid]==1){
                mid++;
            }else{
                swap(mid,right,nums);
                right--;
            }
        }
    }
}