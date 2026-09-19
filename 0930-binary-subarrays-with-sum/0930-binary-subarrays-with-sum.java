class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    } 
    //funtion for sum <= goal  and  sum <= goal-1
    private int atMost(int[] nums, int goal){
        int l = 0;
        int r = 0;
        int sum = 0;
        int countSubarr = 0;
        int n = nums.length;

        while(r < n){
            if(goal < 0) return 0;
            sum = sum + nums[r];

            while(sum > goal){
                sum = sum - nums[l];
                l++;
            }

            countSubarr = countSubarr + (r  - l + 1);
            r++;
        }
        return countSubarr;
    }
}