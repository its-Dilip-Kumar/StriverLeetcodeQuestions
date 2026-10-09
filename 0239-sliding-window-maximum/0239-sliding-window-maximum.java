class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] res=new int[n-k+1];
        if(n==0) return res;
        Deque<Integer> deque=new ArrayDeque<>();
        int idx=0;
        while(idx<k){
            while(!deque.isEmpty() && nums[deque.peekLast()]<=nums[idx]){
                deque.pollLast();
            }
            deque.offerLast(idx);
            idx++;
        }

        res[0]=nums[deque.peekFirst()];

        for(int i=k;i<n;i++){
            if(!deque.isEmpty() && deque.peekFirst()<=(i-k)){
                deque.pollFirst();
            }

            while(!deque.isEmpty() && nums[deque.peekLast()]<=nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
            res[i-k+1]=nums[deque.peekFirst()];
        }

        return res;
    }
}