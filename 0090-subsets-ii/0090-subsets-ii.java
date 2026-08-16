class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        FindSubsets(0, nums, new ArrayList<>(), ans);
        return ans;
    }
    private void FindSubsets(int indx, int [] nums, List<Integer> ds, List<List<Integer>> ans){
        ans.add(new ArrayList<>(ds));
        for(int i = indx; i<nums.length; i++){
            if(i != indx && nums[i] == nums[i - 1]) continue;
            ds.add(nums[i]);
            FindSubsets(i + 1, nums, ds, ans);
            ds.remove(ds.size() - 1);
        }
    }
}