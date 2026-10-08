class LRUCache {
    class Node{
        int key,value;
        Node prev,next;
        public Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }

    private int capacity;
    private HashMap<Integer,Node> map;
    private Node head,tail;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.map=new HashMap<>();
        this.head=new Node(-1,-1);
        this.tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node=map.get(key);
        remove(node);
        addToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.value=value;
            remove(node);
            addToHead(node);
            return;
        }

        Node newNode=new Node(key,value);

        if(map.size()==capacity){
            Node lru=tail.prev;
            remove(lru);
            map.remove(lru.key);
        }
        addToHead(newNode);
        map.put(key,newNode);
    }

    private void remove(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    private void addToHead(Node node){
        node.next=head.next;
        node.prev=head;
        head.next.prev=node;
        head.next=node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */