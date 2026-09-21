class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int minLen = Integer.MAX_VALUE;
        int startIdx = -1;
        int l = 0;
        int r = 0;
        int count = 0;
        int[] hash = new int[256]; //store all English character
        Arrays.fill(hash, 0); //intiall  inserted all zeros
        for(int i = 0; i<m; i++){
            hash[t.charAt(i)]++;
        }
        while( r < n){
            // it is pre inserted
            if(hash[s.charAt(r)] > 0){
                count = count + 1;
            }
            hash[s.charAt(r)]--;
        
            // if count  == t.length, may be this is possible ans
            while(count == m){
                //compare the lenth
                if( r - l + 1 < minLen){
                    minLen = r - l + 1;
                    startIdx = l;
                }
                //but if t.length == count we also try to shrink the window replatetly (or as much as possible)
                // lets remove this l
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)] > 0){
                    count = count - 1;
                }
                l = l + 1;
            }
            r = r + 1;
        }
        if(startIdx == -1){
            return "";
        }
        return s.substring(startIdx, startIdx + minLen);
    }
}