class Solution {
    public int countCommas(int n) {
        if(1000>n){
            return 0;
        }
        return n-1000+1;
    }
}