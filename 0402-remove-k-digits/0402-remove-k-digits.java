class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        //traverse for each and every string(number)
        for(int i = 0; i<num.length(); i++){
            //pop the last  larger ele in stack then curr ele
            while(!st.empty() && k>0 && st.peek()-'0' > num.charAt(i)-'0'){
                st.pop(); //remove the last digit
                k = k-1; //keep the track of removing digits
            }
            //push char into stack
            st.push(num.charAt(i));
        }

        //Edge Cases: after entire traversel k is still left or not removing any ele in stack, is still left so removing only last digits
        while(k>0){
            st.pop();
            k = k-1;
        }
        //Edge Case: once tarversel is complete , stack is empty means -> k == num.length; , after removing k digits so return 0
        if(st.isEmpty()) return "0";

        //Assume stack has some ele , now stringbuilder to store the ans
        StringBuilder res = new StringBuilder();


        //travsering entire stack, add digits into ans
        while(!st.isEmpty()){
            res.append(st.peek()); //add the digits, but by LIFO we get reverse oder string
            st.pop(); //empty the stack
        }

        //now triming the leading zeroes, qus give us no zero leading from start to string, so we start tarvering form the back, because stack give us ans usng LIFO methode, zerose alwayes in the end, and if res has some char, res is not empty the trim zeros feom the back
        while(res.length() > 0 && res.charAt(res.length()-1) == '0'){
            res.deleteCharAt(res.length()-1); //delet the zero
        }
        //reverse the res to get correct order ans
        res.reverse();

        //is stack is empty , and we not add/push ele into stack , if stack has ele all has zerose , in res we trim all zerose means nothing add in res is empty so we return string "0" zero
        if(res.length() == 0) return "0";

        //retun the result as a string
        return res.toString();


        
    }
}