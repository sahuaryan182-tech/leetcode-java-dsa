class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0;
        int l = 0;
        int r = 0;
        while( r < n-1 ){
            int farthst = 0;
            for(int i = l; i<=r; i++){
                farthst = Math.max(i + nums[i], farthst);
            }
            // once I Traverse all the elements in that Range, so new Range
            l = r + 1;
            r = farthst;
            jumps++;
           
        }
        return jumps;
    }
}