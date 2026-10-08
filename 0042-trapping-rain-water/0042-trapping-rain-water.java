class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int maxbuilding=0;
        for(int i=1;i<n;i++){
            if(height[i]>height[maxbuilding]){
                maxbuilding=i;
            }
        }

        int leftmax=height[0];
        int total=0;
        for(int i=0;i<maxbuilding;i++){
            if(leftmax>=height[i]){
                total+=leftmax-height[i];
            }else{
                leftmax=height[i];
            }
        }

        int rightmax=height[n-1];
        for(int i=n-2;i>maxbuilding;i--){
            if(rightmax>=height[i]){
                total+=rightmax-height[i];
            }else{
                rightmax=height[i];
            }
        }

        return total;

    }
}