class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer> st=new Stack<>();
        int maxArea=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                int height=heights[st.pop()];
                int pse=st.isEmpty() ? -1 : st.peek();
                int area=height*(i-pse-1);
                maxArea=Math.max(maxArea,area);
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int height=heights[st.pop()];
            int pse=st.isEmpty() ? -1 : st.peek();
            int area=height*(n-pse-1);
            maxArea=Math.max(maxArea,area);
        }
        return maxArea;

    }
}