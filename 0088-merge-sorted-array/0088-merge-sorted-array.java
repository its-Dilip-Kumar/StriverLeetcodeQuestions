class Solution {
    public static void swap(int i,int j,int[] nums1,int[] nums2){
        int temp=nums1[i];
        nums1[i]=nums2[j];
        nums2[j]=temp;
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left=m-1;
        int right=0;
        while(left>=0 && right<n){
            if(nums1[left]>nums2[right]){
                swap(left,right,nums1,nums2);
                left--;
                right++;
            }else{
                break;
            }
        }

        Arrays.sort(nums1,0,m);
        Arrays.sort(nums2);

        for(int i=0;i<n;i++){
            nums1[m+i]=nums2[i];
        }

    }
}