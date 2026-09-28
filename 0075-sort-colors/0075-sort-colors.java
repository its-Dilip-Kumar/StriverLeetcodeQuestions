class Solution {
    public static void mergeSort(int start,int end,int[] nums){
        if(start>=end){
            return;
        }

        int mid=(start+end)/2;

        mergeSort(start,mid,nums);
        mergeSort(mid+1,end,nums);
        merge(start,mid,end,nums);
    }

    public static void merge(int start,int mid,int end,int[] nums){
        int i=start;
        int j=mid+1;
        int k=0;
        int[] temp=new int[end-start+1];

        while(i<=mid && j<=end){
            if(nums[i]<nums[j]) temp[k++]=nums[i++];
            else temp[k++]=nums[j++];
        }

        while(i<=mid){
            temp[k++]=nums[i++];
        }

        while(j<=end){
            temp[k++]=nums[j++];
        }

        for(k=0,i=start;k<temp.length;k++,i++){
            nums[i]=temp[k];
        }
    }
    public void sortColors(int[] nums) {
        int n=nums.length;
        mergeSort(0,n-1,nums);
    }
}