class Solution {
    public int maxFrequencyElements(int[] nums) {
      int total = 0;
      int maxfreq = 0;
      int[] frq = new int[101];
      for(int i = 0; i<nums.length; i++){
        frq[nums[i]]++;
        int currfrq = frq[nums[i]];
        if(currfrq > maxfreq){
            maxfreq = currfrq;
            total = maxfreq;
        }
        else if(maxfreq == currfrq){
            total = total + maxfreq;
        }
      }
      return total;
    }
}