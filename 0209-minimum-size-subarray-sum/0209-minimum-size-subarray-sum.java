class Solution {
    public int minSubArrayLen(int target, int[] nums) {
    int n = nums.length;
    int l = 0;
    int r = 0;
    int sum = 0;
    int minLen = Integer.MAX_VALUE;
    while( r < n){
        sum = sum + nums[r];


        while(sum >= target){
            int len = r-l+1;
            minLen = Math.min(minLen, len);

            sum = sum - nums[l];
            l++;
        }
        r++;
    }
    return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}