class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[n];
        for(int i=2*n-1;i>=0;i--){
            int idx=i%n;
            while(!st.isEmpty() && st.peek()<=nums[idx]){
                st.pop();
            }

            if(i<n){
                if(st.isEmpty()) ans[idx]=-1;
                else ans[idx]=st.peek();
            }
            st.push(nums[idx]);
        }
        return ans;
    }
}