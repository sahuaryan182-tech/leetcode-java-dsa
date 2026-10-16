class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); // {sum, freq/count of sum, how many time sum ouccr}
        map.put(0, 1);
       int cnt= 0;
       int sum = 0;
       for(int i = 0; i<nums.length; i++){
        sum = sum + nums[i];
        int remove = sum-k;
        cnt = cnt  + map.getOrDefault(remove, 0);
        map.put(sum, map.getOrDefault(sum, 0) +1);
       }
       return cnt;
    }

}