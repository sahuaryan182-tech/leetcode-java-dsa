class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        StringBuilder result = new StringBuilder();

        //store last index of that currnt char
        int[] lastIdx = new int[26];
        Arrays.fill(lastIdx, -1);

        //if i already taken that currnt char into my ans
        boolean[] taken = new boolean[26]; //contain onlu lower emlish latter, -. Intially fasle all

        //fill last index
        for(int i= 0; i<n; i++){
            char ch = s.charAt(i);
            lastIdx[ch-'a'] = i;
        }

        //one by one go each char  cheak is this char samller then me if yes then delete add me(currnt char) in result, 
        for(int i = 0; i<n; i++){
            char ch = s.charAt(i);

            int idx = ch-'a';

            if(taken[idx]){ //if any char is already taken in result go next
                continue;
            }

            //if we not take any char yet,  then chek is this result char is grator then me(currnt) and its index is exit in future

            while(result.length() > 0  && result.charAt(result.length()-1) > ch && lastIdx[result.charAt(result.length()-1)-'a'] > i){
                taken[result.charAt(result.length()-1)-'a'] = false;
                result.deleteCharAt(result.length()-1); //delete that bigger/grator character in result
            }

            result.append(ch);
            taken[idx] = true;
        }
        return result.toString();



    }
}