class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        // to store final ans 
        List<List<Integer>> ans = new ArrayList<>();
        // to store combinations
        List<Integer> combo = new ArrayList<>();
        //call a recusive function
        func(1, 0, n, ans, k, combo); // 1 to 9  -> index, sum = 0 intially, k -> combinations + digit, combo -> to store combinations, n = sum
        //return final ans
        return ans;
    }
    //now function that genrate  k combinations with k diffrent digits
    private void func(int index, int sum, int n, List<List<Integer>> ans, int k ,List<Integer> combo){
        //base case: if sum is equal to givin n ,  and diffent digits -> k is zero 0 then we found combination
        if(sum == n && k == 0){
            ans.add(new ArrayList<>(combo));
            return;
        }
        //edge case: sum is grater then givin  n , return empty list
        if( sum > n){
            return;
        }

        //loop traverse 
        for(int i = index; i<=9; i++){
            if(i > n){
                break;
            }
            combo.add(i);
            //call recusily ti the funtion
            func( i + 1, sum + i, n, ans, k -1, combo);
            combo.remove(combo.size() - 1);
        }

    }
}