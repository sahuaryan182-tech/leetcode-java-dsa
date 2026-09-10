/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
       List<List<Integer>> ans = new ArrayList<>();
       Queue<TreeNode> q = new LinkedList<>();
       if(root == null) return ans;
       q.offer(root);
       boolean LtoR = true;
       while(!q.isEmpty()){
        int size = q.size();
        Integer[] level = new Integer[size];
        for(int i = 0; i<size; i++){
            TreeNode node = q.poll();
            //find postion to fill node value
            int index = LtoR ? i : (size - 1 - i);
            level[index] = node.val;
            if(node.left !=  null) q.offer(node.left);
            if(node.right != null) q.offer(node.right);
        }
        //once entire traversal is done in  level , then filip the flage , inorder to change direction
        LtoR = !LtoR;
        ans.add(Arrays.asList(level));
       }
       return ans;
    }
}