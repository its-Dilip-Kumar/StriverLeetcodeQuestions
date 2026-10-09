class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class StockSpanner {
    Stack<Pair> st;
    int idx;
    public StockSpanner() {
        st=new Stack<>();
        idx=-1;
        st.clear();
    }
    
    public int next(int price) {
        idx=idx+1;
        while(!st.isEmpty() && st.peek().first<=price){
            st.pop();
        }
        
        int ans=idx-(st.isEmpty() ? -1 : st.peek().second);
        st.push(new Pair(price,idx));
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */