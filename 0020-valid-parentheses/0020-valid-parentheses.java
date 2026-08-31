class Solution {
    public boolean isValid(String s) {

        //to store the opning brakets only in stack
        Stack<Character> st = new  Stack<>();
        
        //string to char Array convert it
        for(char ch : s.toCharArray()){
            //put each only opning brackest in stack
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }
            // if there is no opning brakets in given string then return false
            else{
                if(st.isEmpty()) return false;
            

            //if there is opning brakets in stack then copmare 
            //get the top element in stack
            char top = st.pop();
            //st.pop(); // Grabage Collector karlega Java main

            if((ch == ')' && top == '(') ||( ch == '}' && top == '{') || (ch == ']' && top == '[')){
               // return true; -> yeha per true kebal only one pair brakets match hone per dega aage ke pair match nhi karega to continue karo aage ki conditions match  ya true hone ke liye
               continue;
            }
            //if in givin string there is no matched closing brakets
            else{
                return false;
            }
            }

        }
        return st.isEmpty(); // return true if all brakets is matched
        
    }
}