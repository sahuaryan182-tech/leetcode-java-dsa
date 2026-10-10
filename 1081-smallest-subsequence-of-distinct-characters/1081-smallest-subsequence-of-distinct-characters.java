class Solution {
    public String smallestSubsequence(String s) {
        int n = s.length();
        boolean[] taken = new boolean[26];
        int[] lastIdx = new int[26];
       
        StringBuilder result = new StringBuilder();

        //fill last index
        for(int i = 0; i<n; i++){
            char ch = s.charAt(i);
            lastIdx[ch-'a'] = i;
        }

        // reslut add hoga sabse smallest phale
        for(int i = 0; i<n; i++){
            char ch = s.charAt(i);
            int idx = ch-'a';

            if(taken[idx]){
                continue;
            }
            while(result.length() > 0 && result.charAt(result.length()-1) > ch && lastIdx[result.charAt(result.length()-1)-'a'] > i){
                taken[result.charAt(result.length()-1)-'a'] = false;
                result.deleteCharAt(result.length()-1);
            }

            result.append(ch);
            taken[idx] = true;
        }

        return result.toString();
    }
}