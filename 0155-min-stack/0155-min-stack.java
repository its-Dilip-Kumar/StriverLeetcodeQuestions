class Pair{
    int val;
    int min;
    public Pair(int val,int min){
        this.val=val;
        this.min=min;
    }
}
class MinStack {
    Stack<Pair> st;
    public MinStack() {
        st=new Stack<Pair>();
    }
    
    public void push(int value) {
        if(st.isEmpty()){
            st.push(new Pair(value,value));
        }else{
            int currMin=Math.min(value,st.peek().min);
            st.push(new Pair(value,currMin));
        }
    }
    
    public void pop() {
        if(st.isEmpty()){
            return;
        }
        st.pop();
    }
    
    public int top() {
        if(st.isEmpty()) return -1;
        return st.peek().val;
    }
    
    public int getMin() {
        if(st.isEmpty()) return -1;
        return st.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */