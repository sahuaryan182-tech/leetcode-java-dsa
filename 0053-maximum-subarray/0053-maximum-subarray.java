class Solution {
    public int maxSubArray(int[] nums) {
        long maxi = Long.MIN_VALUE;
        long sum = 0;
        for(int i= 0; i < nums.length; i++){
            sum = sum + nums[i];
            //put sum pos(+) val in maxi
            if( sum > maxi){
                maxi = sum;
            }
            if(sum < 0){
                // reinislize sum
                sum = 0;
            }
        }
        // long to int
        return (int) maxi;
        
    }
}