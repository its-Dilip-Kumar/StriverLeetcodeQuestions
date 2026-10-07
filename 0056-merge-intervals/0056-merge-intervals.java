class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        ArrayList<int[]> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(ans.size()==0){
                ans.add(intervals[i]);
            }else{
                if(ans.get(ans.size()-1)[1]>=intervals[i][0]){
                    ans.get(ans.size()-1)[0]=Math.min(ans.get(ans.size()-1)[0],intervals[i][0]);
                    ans.get(ans.size()-1)[1]=Math.max(ans.get(ans.size()-1)[1],intervals[i][1]);
                }else{
                    ans.add(intervals[i]);
                }
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}