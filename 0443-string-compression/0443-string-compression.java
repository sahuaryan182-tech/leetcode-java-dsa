class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
    int idx = 0;
    for(int i = 0; i<chars.length; i++){
        int count = 0;
        char ch = chars[i];
        while( i < n && ch == chars[i]){
            count++;
            i++;
        }

        if(count == 1){
            chars[idx] = ch;
            idx++;
        }
        else{
            chars[idx++] = ch;
            String str = String.valueOf(count);
         
            for(char dig  : str.toCharArray()){
               chars[idx] = dig;
                idx++;
            }
        }
        i--;
    }
    return idx;
    }
}