class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int sum = 1; // To compute the total sum
        int i = 1; // To Traver each ele in arr

        while( i < n){
            // If it is a flat suface not a curve
            if(ratings[i] == ratings[i-1]){
                sum = sum + 1;
                i++;
                continue;
            }
            int peak = 1;

            // If it is a Incresing Curve 
            while( i < n && ratings[i] > ratings[i-1]){
                peak = peak + 1;
                sum = sum + peak;
                i++;
            }
            
            int down = 1;

            // It is a Decresing Cureve
            while( i < n && ratings[i] < ratings[i-1]){
                sum = sum + down;
                down = down + 1;
                i++;
            }
            
            if( down > peak){
                sum = sum + (down - peak);
            }
        }
        return sum;
    }
}  