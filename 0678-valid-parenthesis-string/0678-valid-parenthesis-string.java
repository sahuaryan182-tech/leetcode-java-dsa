class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        int min = 0;
        int max = 0;
        for(int i = 0; i<n; i++){
            // If it is a '('
            if(s.charAt(i) == '('){
                min = min + 1;
                max = max + 1;
            } // If it is a ')'
            else if(s.charAt(i) == ')'){
                min = min - 1;
                max = max - 1;
            }
            else{  // Means it is a '*' three combinations -> +1, +0, -1
                min = min - 1;
                max = max + 1;
            }
            // it might gose to negaitive min Range
            // trim dwon the range form left side(smaller number)
            // In that case we know that max is has somthing positive number
            if(min < 0) min = 0; // Discard the neg number keep range 0
            if(max < 0) return false;

        }
        return (min == 0);
    }
}