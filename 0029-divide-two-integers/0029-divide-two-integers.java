class Solution {
    public int divide(int dividend, int divisor) {
        //base case 
        if(dividend == divisor) return 1;
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if(divisor == 1) return dividend;

        boolean Sign = true;
        if(dividend >= 0 && divisor < 0){
            Sign =  false;
        }
        if(dividend <0 && divisor >= 0){
            Sign =  false;
        } 
        
        long n = dividend;
        long d = divisor;

        n = Math.abs(n);
        d = Math.abs(d);
        
        long ans = 0;
        while( n >= d){
            int cnt = 0;
            while( n >= (d << ( cnt + 1 ))){
                cnt++;
            }
            ans = ans + (1L << cnt); 
            n = n - ( d << cnt);
           
        }
         if(ans > Integer.MAX_VALUE && Sign){
            return Integer.MAX_VALUE;
        }
        return Sign ? (int) ans : (int) (-ans);

        
    }
}