class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        int maxLen = 0;
        int zeroCount = 0;
        while(r<n){
            if(nums[r] == 0) zeroCount++;

            if(zeroCount > k){
                if(nums[l] == 0) zeroCount--;
                l++;
            }

            if(zeroCount <= k){
                int len = r - l + 1;
                maxLen = Math.max(maxLen, len);
            }
            r++;

        }
        return maxLen;
    }
}