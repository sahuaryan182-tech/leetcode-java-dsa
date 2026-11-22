class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        subSets(nums, 0, ans, new ArrayList<>());
        return ans;
    }
    private void subSets(int[] arr, int start, List<List<Integer>> ans, List<Integer> temp){
        ans.add(new ArrayList<>(temp));
        for(int i = start; i <arr.length; i++){
            temp.add(arr[i]);
            subSets(arr, i + 1, ans, temp);
            temp.remove(temp.size()-1);
        }
    }
}