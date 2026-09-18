class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l = 0;
        int r = 0;
        int maxLen = 0;

        int[] hash = new int[256];

        // Intially fll every where -1  in map , means we can see it
        Arrays.fill(hash, -1);

        while(r<n){
            //if curr char is see already o prent in map
            if(hash[s.charAt(r)] != -1){
                //chech this already seen char is lia in winow 
                if(hash[s.charAt(r)] >= l){
                    // if yes it lia in window the update l
                    l = hash[s.charAt(r)] + 1;
                }
            }
            int len = r - l + 1;
            maxLen = Math.max(len, maxLen);
        
            // Store the Currnt charcter index in hashmap table
            hash[s.charAt(r)] = r; // current index -> r
            //move the currnt right pointer index to the left to right 
            r++;
        }

        return maxLen;
        
    }
}