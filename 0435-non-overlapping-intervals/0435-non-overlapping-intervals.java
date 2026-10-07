class Data{
    int start;
    int end;
    public Data(int start,int end){
        this.start=start;
        this.end=end;
    }
}
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length;
        Data[] interval=new Data[n];
        for(int i=0;i<n;i++){
            interval[i]=new Data(intervals[i][0],intervals[i][1]);
        }

        Arrays.sort(interval,(a,b)->Integer.compare(a.end,b.end));
        int endtime=interval[0].end;
        int count=1;
        for(int i=0;i<n;i++){
            if(endtime<=interval[i].start){
                count++;
                endtime=interval[i].end;
            }
        }
        return n-count;
    }
}