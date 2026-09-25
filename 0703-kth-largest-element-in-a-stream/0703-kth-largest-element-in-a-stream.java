class KthLargest {
    // Globel PriorityQUeue so that add also access this MinHeap(PriorityQueue)
    PriorityQueue<Integer> minHeap;
    // Globel Varial so that add fuction also access this varibale
    int K;

    public KthLargest(int k, int[] nums) {
        // k is a local variable so add fuction an not be accessed
        // so we need to Declear this varibal as Globel Variabel
        K = k;
        //minHeap is local to the constructor
        //You declared:
        //PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //Then add() cannot access it.

        // Min Heap
        minHeap = new PriorityQueue<>();
        int n = nums.length;

        for(int i = 0; i<n; i++){
            minHeap.offer(nums[i]);
            if(minHeap.size() > k){
                minHeap.poll(); // Minimum element will be popped
            }
        }
    }
    
    public int add(int val) {

        minHeap.offer(val);

        if(minHeap.size() > K){
            minHeap.poll();
        }
        
        return minHeap.peek();  // correct call / Valid call (Quistions Givin)
        
        
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */