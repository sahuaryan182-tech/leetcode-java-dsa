class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();

        for(int i = 0; i<n; i++){
            String word = strs[i]; //eat in string variable

            String new_word = Genrate(word);

            // stroe the new word(key) in map and also store against currnt word we give in String list in map as Values of Key
            map.computeIfAbsent(new_word, w -> new ArrayList<>()).add(word);



        }

        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            ans.add(entry.getValue());
        }

        return ans;
    }
    private String Genrate(String word){
        int[] freq = new int[26]; // for lowercase latter
        for(char c : word.toCharArray()){
            freq[c-'a']++;
        }

        

        StringBuilder new_word = new StringBuilder();

        for(int i = 0; i<26; i++){
            int freqq = freq[i];

            if(freqq > 0){
                for(int j = 0; j<freqq; j++){
                    new_word.append((char)(i+'a'));
                }
            }
        }
        return  new_word.toString();
    }
}