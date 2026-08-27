class Solution {
    public int countPrimes(int n) {
        boolean[] PrimeNum = new boolean[n + 1];
        //mark as 1
        for(int i = 2; i<=n; i++){
            //mark it as 1
            PrimeNum[i] = true;
        }
        for(int i = 2;  i * i <= n; i++){
            //cheak if it is prime number
            if(PrimeNum[i] == true){
                //mark only prime number multiple by 2 to n  and mark single prime number as -> 0
                for(int j = i * i; j <= n; j = j + i){
                    PrimeNum[j] = false; //makr prime number multiple as 0 zero
                }
            }
        }
        int cnt = 0;
        //now return all prime umber count 
        for(int i = 2; i<n; i++){
            if(PrimeNum[i] == true){
                //calculate or count how many prime number is marked true or till givin n
                cnt++;
            }
        }
        return cnt;
    }
}