class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] lastSeen = {-1, -1, -1};
        int count = 0; //keep a track of Substring in valid window
        for(int i = 0; i<n; i++){
            //put the current character index of last seen char in arr
            lastSeen[s.charAt(i) - 'a'] = i;
            //if this is valid window, find left most char(till valid) and add 1 in the laftmost index char
            if(lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1){
                count = count + (1 + Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2])));
            }

        }
        return count;
        
    }
}