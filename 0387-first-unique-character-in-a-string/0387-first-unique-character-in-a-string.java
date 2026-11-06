class Solution {
    public int firstUniqChar(String s) {
        int[]  f = new int[26];
        for(int i = 0; i<s.length(); i++){
            f[s.charAt(i)-'a']++;
        }

        for(int i= 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(f[c-'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}