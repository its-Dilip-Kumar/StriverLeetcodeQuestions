class Solution {
    public static int solve(int[] heights){
        int n=heights.length;
        int maxArea=Integer.MIN_VALUE;
        Stack<Integer> st=new Stack<>();
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
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int maxArea=Integer.MIN_VALUE;
        int[] heights=new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1'){
                    heights[j]++;
                }else{
                    heights[j]=0;
                }
            }
            int area=solve(heights);
            maxArea=Math.max(maxArea,area);
        }
        return maxArea;
    }
}