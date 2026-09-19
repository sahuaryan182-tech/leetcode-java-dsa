class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k-1);
    }
    private int atMost(int[] nums, int k){
        //givin arr only contains int positive
        if(k < 0) return 0;
        int n = nums.length;
        int l = 0;
        int r = 0;
        int sum = 0;
        int countSubarr = 0;
        
        while(r < n){
            //add curent element to sum if it if odd -> 1, and even -> 0
            sum = sum + nums[r] % 2;

            // Shrink the window if it exeeds the k
            while( sum > k){
                sum = sum - nums[l] % 2;
                l++;
            }

            // add the number of valid subarray count ending at right
            countSubarr = countSubarr + (r -  l + 1);

            //move the right ponter
            r++;
        }
        return countSubarr;
    }
}