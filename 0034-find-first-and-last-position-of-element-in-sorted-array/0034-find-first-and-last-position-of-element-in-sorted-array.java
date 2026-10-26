class Solution {
    public int[] searchRange(int[] nums, int target) {
        int frist = FristOccur(nums, target);
        int last = LastOccur(nums, target);
        return new int[]{frist, last};

    }
    private int FristOccur(int[] nums, int x){
        int l = 0;
        int h = nums.length-1;
        int ans = -1;
        while(l<=h){
            int m = (l+h)/2;
            if(nums[m] == x){
                ans = m;
                h = m-1;
            }
            else if(nums[m] < x){
                l = m+1;
            }
            else{
                h = m-1;
            }
        }
        return ans;
    }

    private int LastOccur(int[] nums, int x){
        int l = 0;
        int h = nums.length-1;
        int ans = -1;
        while(l<=h){
            int m = (l+h)/2;
            if(nums[m] == x){
                ans = m;
                l = m + 1;
            }
            else if(nums[m] < x){
                l = m+1;
            }
            else{
                h = m-1;
            }
        }
        return ans;
    }
}