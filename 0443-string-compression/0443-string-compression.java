class Solution {
    public int compress(char[] chars) {
     
        int Idx = 0;
       int j = 0;
        for(int i = 0; i<chars.length; ){
            char ch = chars[i];
            int cnt = 0;
            while(j < chars.length &&  ch == chars[j]){
                cnt++;
                j++;
            }
            if(cnt == 1){
                chars[Idx] = ch;
                Idx++;
            }
            else{
                chars[Idx] = ch;
                Idx++;
                String dig = String.valueOf(cnt);
                for(char val : dig.toCharArray()){
                    chars[Idx] = val;
                    Idx++;
                }
            }
            //manually advance i to skip the characters you already processed in the while loop.
            i = j;
            
        }
        return Idx;
    }
}