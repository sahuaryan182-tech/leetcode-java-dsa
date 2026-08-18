class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0){
            return ans;
        }
        String [] options = {"","", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        helper(0, digits, "", options, ans);
        return ans;
    }
    private void helper(int index, String digits, String output, String [] options, List<String> ans){
        //base case
        if(index == digits.length()){
            ans.add(output);
            return;
        }
        //current digits
        int num = digits.charAt(index) -'0';
        


        String letters = options[num];

        for(int i = 0; i<letters.length(); i++){
            helper(index + 1, digits, output + letters.charAt(i), options, ans);
        }
    }
}