class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();

        solve(0, num, target, "", ans, 0, 0);

        return ans;
         
    }
    private void solve(int index, String num, int target, String current, List<String> ans, long previous, long res){
        //base case: if index is  == num.length then cheak res is equal to target
        if(index == num.length()){
            if(res  == target){
                //add current string to the ans
                ans.add(current);
            }
            //if we raech last index return string
            return;
        }
        String st = ""; //entially empty
        long CurrRes = 0;
        //for loop, it use for to make single and multiple number
        for(int i = index; i<num.length(); i++){
            //contains a zero like 7+0, but not leading a zero like -> 7+0*9 or 7*0+9
            if(i>index && num.charAt(index) == '0') break;

            //now add current string to the st
            st = st + num.charAt(i);

            //now add final after operations ans 2+3*2 -> 8 string to long int conversion
            CurrRes = CurrRes * 10 + num.charAt(i) - '0';

            //now if we do opration in frist index means no privious ans res 
            if(index == 0){                      //as a -> privious and as a res
                solve(i+1, num, target, st, ans, CurrRes, CurrRes);
            }
            //index is not 0 , means we we already peroform some oprations , means also have privious and res
            else{
               //now we call the funtion recusivly for -> +
                solve(i+1, num, target, current+'+'+st, ans, CurrRes, res + CurrRes);

               //now we call the funtion recusivly for -> -
               solve(i+1, num, target, current+'-'+st, ans, -CurrRes, res - CurrRes);

               //now we call the funtion recusivly for -> *
               solve(i+1, num, target, current+'*'+st, ans, previous*CurrRes, res - previous+(previous * CurrRes));

            }
        }

    }
}