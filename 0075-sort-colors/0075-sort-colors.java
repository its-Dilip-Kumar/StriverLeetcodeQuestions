class Solution {
    public static void merge(int[] nums,int start,int mid,int end){
        int i=start;
        int j=mid+1;
        int k=0;
        int[] temp=new int[end-start+1];
        while(i<=mid && j<=end){
            if(nums[i]<=nums[j]){
                temp[k++]=nums[i++];
            }else{
                temp[k++]=nums[j++];
            }
        }

        while(i<=mid){
            temp[k++]=nums[i++];
        }

        while(j<=end){
            temp[k++]=nums[j++];
        }

        for(int x=0;x<temp.length;x++){
            nums[start+x]=temp[x];
        }
    }
    public static void mergesort(int[] nums,int start,int end){
        if(start>=end) return;
        int mid=start+(end-start)/2;
        mergesort(nums,start,mid);
        mergesort(nums,mid+1,end);
        merge(nums,start,mid,end);
    }
    public void sortColors(int[] nums) {
        int n=nums.length;
        mergesort(nums,0,n-1);
    }
}