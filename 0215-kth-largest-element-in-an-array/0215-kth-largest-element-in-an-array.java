class Solution {
    public int findKthLargest(int[] nums, int k) {
       PriorityQueue<Integer> minHeap = new PriorityQueue<>();
       int n = nums.length;
       int ans = 0;
       for(int i = 0; i<n; i++){

        minHeap.add(nums[i]);
        if(minHeap.size() > k){
            minHeap.poll();
        }

       }
       ans = minHeap.peek();
       return ans;
            
    }
}