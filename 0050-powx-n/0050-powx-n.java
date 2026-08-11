class Solution {
    public double myPow(double x, int n) {
        double ans = 1.0;
        long N = n;
        //edge case
        if(n == 0) return 1;

        //make power  n negative  to positive number
        if(N < 0) N = N * -1;

        //if power n is positive number 
        while(N>0){
            // if power n is evem 
            if(N % 2 == 0){
                x = x * x;
                N = N / 2;
            }
            //if n is odd power
            else{
                ans  = ans * x;
                N = N - 1;
            }
        }
        // if given power is n is negative number 
        if(n < 0) {
            ans  = (double)(1.0) / (double)(ans);
        }
        return ans;
    }
}