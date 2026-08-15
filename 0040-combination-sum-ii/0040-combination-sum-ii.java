class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //to store ans list of list integer
        List<List<Integer>> ans = new ArrayList<>();
        //sort the arr
        Arrays.sort(candidates);
        // call the recursion
        findCombinations(0, candidates, target, ans, new ArrayList<>());

        //return the final ans data stucture
        return ans;
        

    }
    //the funtion that recusivly call and compute combinations by avoding duplicates
    private void findCombinations(int indx, int [] arr, int target, List<List<Integer>> ans, List<Integer> ds){
        //base case: if tager is the that combinations in ds is our answare
        if(target == 0){
            ans.add(new ArrayList<>(ds)); //put ds combination into ans and return it
            return;
        }
        //looping through element starting index
        for(int i = indx; i<arr.length; i++){
            //skip duplicates elements to not pick it
            if(i > indx && arr[i] == arr[i-1]) continue;
            //any thing in rigth not pick it (sorted arr-> rigth has higher element)
            if(arr[i] > target) break;

            //if we pick it then add it into ouu ds -> data-stucture
            ds.add(arr[i]);
            //call the Recursion, i is here because we inside a loop and the itrate variable is -> i
            findCombinations(i + 1, arr, target - arr[i], ans, ds);
            //Backtraking by removing the last element
            ds.remove(ds.size() - 1);

        }
    }
}