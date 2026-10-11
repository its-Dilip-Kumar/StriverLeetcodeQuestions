class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n=arr.length;
        int[] copyArr=Arrays.copyOf(arr,n);
        Arrays.sort(copyArr);
        HashMap<Integer,Integer> map=new HashMap<>();
        int rank=1;
        for(int i=0;i<n;i++){
            if(i>0 && copyArr[i]>copyArr[i-1]){
                rank=rank+1;
            }
            map.put(copyArr[i],rank);
        }

        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=map.get(arr[i]);
        }
        return ans;
    }
}