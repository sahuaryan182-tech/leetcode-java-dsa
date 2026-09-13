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
    class Pair{
        TreeNode node; //store node 
        int num; //store index 
        Pair(TreeNode _node, int _num){
            node = _node;
            num = _num;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair> q = new LinkedList<>();
        int ans = 0; 
        q.offer(new Pair(root, 0)); //intially frist root with index
        while(!q.isEmpty()){
            int first = 0; //leftmost child index
            int last = 0; //rightmost child index
            int size = q.size(); //pop still q currnt size
            int min = q.peek().num; //to make index starting form zero
            for(int i = 0; i<size; i++){
                int curr_Indx = q.peek().num - min; //num q main index hai
                TreeNode node = q.peek().node;
                q.poll();
                //now overflow condition to make index smaller
                if(i == 0) first = curr_Indx;
                if(i == size-1) last = curr_Indx;
                if(node.left != null){
                    q.offer(new Pair(node.left, curr_Indx * 2 + 1));
                }
                if(node.right != null){
                    q.offer(new Pair(node.right, curr_Indx * 2 + 2));
                }
            }
            ans = Math.max(ans, (last - first + 1));
        }
        return ans;
    }
}