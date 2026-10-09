class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        int maxfreq = 0;
        int totalfreq = 0;
        for(int i = 0; i<nums.length; i++){
            //count currnt frenquncy
            freq[nums[i]]++;

           

            //currnt frequncy
            int currFreq = freq[nums[i]];

            // curr freq is gartor then maxfre
            if(currFreq > maxfreq){
                // reset the total
                maxfreq = currFreq;
                totalfreq = maxfreq;
            }
            else if(currFreq == maxfreq){
                totalfreq = totalfreq + maxfreq;
            }
        }
        return totalfreq;
    }
}