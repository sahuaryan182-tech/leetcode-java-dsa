class Solution {
    public boolean backspaceCompare(String s, String t) {
        int n = s.length();
        int m = t.length();


        int skip_s = 0;
        int skip_t = 0;

        int i = n-1;
        int j = m-1;

        while( i >= 0 || j>= 0){
             

            while(i>=0){
                if(s.charAt(i) == '#'){
                    skip_s++;
                    i--;
                }
                else if(skip_s > 0){
                    skip_s--;
                    i--;
                }
                else{
                    break; //we found an char
                }

            }

            while(j>=0){
                if(t.charAt(j) == '#'){
                    skip_t++;
                    j--;
                }
                else if(skip_t > 0){
                    skip_t--;
                    j--;
                }
                else{
                    break;
                }


            }

            char S = i < 0 ? '$' : s.charAt(i);
            char T = j < 0 ? '$' : t.charAt(j); 


            if( S != T){
                return false;
            }
            else{
                i--;
                j--;
            }
        }
        return true;
    }
}