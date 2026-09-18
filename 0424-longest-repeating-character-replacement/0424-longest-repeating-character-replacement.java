class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int l = 0;
        int r = 0;
        int maxLen = 0;
        int maxFreq = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(r<n){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) +1);

            // find the maximun Frequncy char in map
            maxFreq = Math.max(maxFreq, map.get(s.charAt(r)));

            // character that need to be replaced
            int changes = (r - l + 1) - maxFreq;
            
            //if more than k replacement are neded
            if(changes > k){
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }
            
            //update the ans
            maxLen = Math.max(maxLen, r - l + 1);
            //move rigth ponter 
            r++;


        }
    return maxLen;
        
    }
    
}