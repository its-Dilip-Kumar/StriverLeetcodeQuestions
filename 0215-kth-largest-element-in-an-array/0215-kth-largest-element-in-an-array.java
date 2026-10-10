class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder());
        for(int num:nums){
            pq.add(num);
        }
        int num=0;
        while(k-->0){
            num=pq.poll();
        }
        return num;
    }
}