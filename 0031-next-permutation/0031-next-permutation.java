class Solution {
    public static void swap(int i,int j,int[] nums){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public static void reverse(int i,int j,int[] nums){
        int left=i;
        int right=j;
        while(left<=right){
            swap(left,right,nums);
            left++;
            right--;
        }
    }
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int pivot=-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                pivot=i;
                break;
            }
        }

        if(pivot==-1){
            reverse(0,n-1,nums);
            return;
        }

        int gtp=-1;
        for(int i=n-1;i>=0;i--){
            if(nums[i]>nums[pivot]){
                gtp=i;
                break;
            }
        }

        swap(pivot,gtp,nums);
        reverse(pivot+1,n-1,nums);
    }
}