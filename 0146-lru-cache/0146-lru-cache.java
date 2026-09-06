class LRUCache {
    class Node{
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value){ //crate a new node
            this.key = key;
            this.value = value;
        }
    }
    //create a dummy node
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);

    int capacity;
    HashMap<Integer, Node> map = new HashMap<>(); //(key, address)

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    //remove a node from a doubly linked-list
    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //add a node just right after head
    private void add(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    
    
    public int get(int key) {
        //if key in hashmap not exist
        if(!map.containsKey(key)){
            return -1;
        }   
        //in  map key exist get addres at the peticulaer key in doubly linked list
        Node node = map.get(key);
        //this key node is now last reacently used ele 
        remove(node); //it is a funtion call in doubly linked list
        //last frequntly used ele so inserted in map
        add(node); //it is a funtion call in doubly linked list
        return node.value;
    }
    
    public void put(int key, int value) {
        //if key already exist in map , but same has diffrent value
        if(map.containsKey(key)){
          Node node = map.get(key);
          node.value = value; //add diffrent value

          remove(node); //it is a funtion call in doubly linked list
          add(node); //it is a funtion call in doubly linked list

          return;
        }
        //in Hashmap if key is not exist then create a new node with {key, value} also cheack is it dose not exceded the capacity
        //create a new node
        Node node = new Node(key, value);
        map.put(key, node);
        add(node); //add in doubly linked list, it is a funtion call the funtion

        if(map.size() > capacity){
            //remove and delete the Least Recently used 
            //tail.prev → least recently used (just left of tail)
            //head.next → most recently used
            Node lru = tail.prev;                          
            remove(lru); //doubly linked-list it is a funtion, call thef funtion
            map.remove(lru.key);  //remove in HashMap
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */