class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();

        helper(0, s, new ArrayList<>(), ans);

        return ans;
    }

    private void helper(
        int index,
        String s,
        List<String> ds,
        List<List<String>> ans
    ) {

        // Base case
        if (index == s.length()) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        // Try every possible substring
        for (int i = index; i < s.length(); i++) {

            // Check whether s[index...i] is palindrome
            if (isPalindrome(s, index, i)) {

                // PICK
                ds.add(s.substring(index, i + 1));

                // RECURSE
                helper(i + 1, s, ds, ans);

                // BACKTRACK
                ds.remove(ds.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }
}