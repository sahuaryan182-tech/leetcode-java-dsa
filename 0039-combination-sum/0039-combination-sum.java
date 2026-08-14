class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //Return ans of list of list int, tha Data-Satucture we use - ArrayList
        List<List<Integer>> ans = new ArrayList<>();

        //start Recusion call funtion, start the recursive search
        findCombinations(0, candidates, target, ans, new ArrayList<>());

        //return the ans - actual data stucture 
        return ans;
    }
    //now the Recuersive funtions that find all combinations sum
    private void findCombinations(int index, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds){
        //base case:if we consider all elemnt in arr
        if(index == arr.length){
            //if target is zero then we have to find valid combinations
            if(target  == 0){
                //add current combination to the result(ans) by ds
                ans.add(new ArrayList<>(ds));
            }
            return; // return end of the recusion
        }
        //Pick Conditions, we are usally cheak the valid target berfor picking
        if(arr[index] <= target){
            ds.add(arr[index]); //add the current element in combinations ds
            //call the recusion function
            //continue with same element to allow reapeted elements
           findCombinations(index, arr, target - arr[index], ans, ds);
           //when Recusion call back, Backtarck remove the last Inserted element in ds
           //Backtraking by removing the last added element 
           ds.remove(ds.size() - 1);
        }
        //if we not picking the elements
        //skip the current element to move next element
        findCombinations(index + 1, arr, target, ans, ds);
    }
}