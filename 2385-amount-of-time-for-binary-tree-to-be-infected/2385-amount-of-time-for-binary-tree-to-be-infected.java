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
    public int amountOfTime(TreeNode root, int start) {
       HashMap<TreeNode, TreeNode> parent_track = new HashMap<>();
       TreeNode target = bfsToMarkParent(root, parent_track, start);
       int maxi = findMaxdistance(parent_track, target); 
       return maxi;
    }
    //funtion to travese bfs and mark parent of L/R child and give the node by refrence start.val
    private TreeNode bfsToMarkParent(TreeNode root, HashMap<TreeNode, TreeNode> parent_track, int start){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode res = new TreeNode(-1);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.val == start) res = curr; //give the start node by refrencing start value
            if(curr.left != null){
                q.offer(curr.left);
                parent_track.put(curr.left, curr);
            }
            if(curr.right != null){
                q.offer(curr.right);
                parent_track.put(curr.right, curr);
            }
        }
        return res;
    }
    //Function to calculate minimum time to burn the entire tree from the target node
    //start form second bfs traversel
    private int findMaxdistance(HashMap<TreeNode, TreeNode> parent_track, TreeNode target){
        Queue<TreeNode> q = new LinkedList<>();
        // BFS starting from the target node to burn all nodes at min time taken
        HashMap<TreeNode, Integer> visited = new HashMap<>();
        q.offer(target);
        visited.put(target, 1);
        int maxi = 0; //max amout of time taken to
        //sconed bfs starnderd traversel
        while(!q.isEmpty()){
            int size = q.size();
            int flag = 0; //means -> we visited that node -> 1 or not -> 0
            for(int i = 0; i<size; i++){
                TreeNode current = q.poll();
                //Expolre th left node 
                if(current.left != null && visited.get(current.left) == null){
                    flag = 1;
                    visited.put(current.left, 1);
                    q.offer(current.left);
                }
                //expolre the right node child
                if(current.right != null && visited.get(current.right) == null){
                    flag = 1;
                    visited.put(current.right, 1);
                    q.offer(current.right);
                }
                //expolre the parent form the hash map(parent_track)
                if(parent_track.get(current) != null && visited.get(parent_track.get(current)) == null){
                    flag = 1;
                    visited.put(parent_track.get(current), 1);
                    q.offer(parent_track.get(current));
                }
            }
            if(flag == 1) maxi++;

        }
        return maxi;

    }
}