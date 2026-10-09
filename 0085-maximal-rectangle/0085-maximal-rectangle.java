class Solution {
    public static int solve(int[] height){
        int n=height.length;
        int[] pse=new int[n];
        int[] nse=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && height[st.peek()]>=height[i]){
                st.pop();
            }
            pse[i]=st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && height[st.peek()]>=height[i]){
                st.pop();
            }
            nse[i]=st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        int maxArea=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int h=height[i];
            int width=nse[i]-pse[i]-1;
            int area=h*width;
            maxArea=Math.max(maxArea,area);
        }

        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int maxArea=Integer.MIN_VALUE;
        int[] height=new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1'){
                    height[j]++;
                }else{
                    height[j]=0;
                }
            }

            int area=solve(height);
            maxArea=Math.max(maxArea,area);
        }
        return maxArea;
    }
}