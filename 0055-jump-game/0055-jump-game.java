class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxIndex = 0;
        for(int i = 0; i<n; i++){
            //if the current index is beyouend furthest(max Index) index , this postions can not be reached
            if(i > maxIndex){
                return false;
            }
            // from reachable index try to extand furthest reacble index
            maxIndex = Math.max(maxIndex,  i + nums[i]);
        }
        return true;
    }
}