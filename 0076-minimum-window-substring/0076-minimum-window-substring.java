class Solution {
    public String minWindow(String s, String t) {
       int n = s.length();
       int m = t.length();
       int[] hash = new int[256];
       int minLen = Integer.MAX_VALUE;
       int cnt = 0;
       int startIdx = -1;
       int l = 0;
       int r = 0;
       // pre-Inserted of t char
       for(int i = 0; i<m; i++){
        hash[t.charAt(i)]++;
       }

       while( r < n){
        if(hash[s.charAt(r)] > 0){
            cnt++;
        }
        hash[s.charAt(r)]--;

        while(cnt == m){
        if(r-l+1 < minLen){
            minLen = r-l+1;
            startIdx = l;
        }

        hash[s.charAt(l)]++;
        if(hash[s.charAt(l)] > 0){
            cnt--;
        }
        l++;
        }
        r++;
       }
       return startIdx == -1 ? "" : s.substring(startIdx, startIdx + minLen);
    }
}