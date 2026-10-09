class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       HashMap<Integer, Integer> map = new HashMap<>(); //{freq, ele}
      
       for(int i = 0; i<nums.length; i++){
        map.put(nums[i], map.getOrDefault(nums[i], 0) +1);
       }

       PriorityQueue<int []> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0])); //{freq, ele} sort by freq higher in 

        //push ele in minheap and maintain size of k only in min heap
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int val = entry.getKey();
            int freq = entry.getValue();

            minHeap.offer(new int[]{freq, val});

            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        // Build ans  
        int[] ans =  new int[k];
        for(int i = 0; i<k; i++){
            ans[i] = minHeap.poll()[1];
        }
        
        return ans;
        
    }
}