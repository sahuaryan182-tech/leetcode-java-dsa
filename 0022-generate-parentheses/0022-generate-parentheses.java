class Solution {
    public List<String> generateParenthesis(int n) {
        //return kara hai list of string, in this has a opninig and closing pranthses
        List<String> ans = new ArrayList<>();

        //opning braket paranthesis count = "("
        int oc = 0;
        //closing braket paranthesis count = ")"
        int cc = 0;

        //create a function to call and gerrate a blanced paranthese
        genrateBalPran(ans, oc, cc, n, ""); //-> intially string empty hai s = ""

        //return this list of paranthesis string
        return ans;

    }
    private static void genrateBalPran(List<String> ans , int oc, int cc, int n, String s){
        //base case / edge case: if oc is equal to n and cc is equal to n then add in list and return it
        if(oc == n && cc == n){
            ans.add(s);
            return;
        }

        //case 1: if oc is lessr then givin n then add opening braket "(" in list by calling the function its self -> recursion
        if(oc < n){
            genrateBalPran(ans, oc + 1, cc, n, s + "(");
        }

        if(cc < oc){
            genrateBalPran(ans, oc, cc + 1, n, s + ")");
        }


    }
}