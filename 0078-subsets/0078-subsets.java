class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //TO STORE ANS
        List<List<Integer>> ans  =  new ArrayList<>();
        //call the recursion
        func(0, nums, new ArrayList<>(), ans);

        //return final ans
        return ans;
    }
    private void func(int index, int [] nums, List<Integer> ds, List<List<Integer>> ans){
        //add current Subset to the final ans 
        ans.add(new ArrayList<>(ds));

        //try every remaining elements
        for(int i = index; i<nums.length; i++){
            
            //pick the element
            ds.add(nums[i]);

            //move to next element
            func( i + 1, nums, ds, ans);

            //Backtraking
            ds.remove(ds.size() - 1);

        }
    }
}