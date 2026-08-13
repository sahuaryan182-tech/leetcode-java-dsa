class Solution {
    static long MOD = 1000000007;

    public int countGoodNumbers(long n) {

        long even = (n + 1) / 2;
        long odd = n / 2;

        long ans = power(5, even) * power(4, odd);

        return (int)(ans % MOD);
    }

    public long power(long x, long n) {

        if (n == 0) {
            return 1;
        }

        long half = power(x, n / 2);

        half = (half * half) % MOD;

        if (n % 2 == 0) {
            return half;
        }

        return (half * x) % MOD;
    }
}