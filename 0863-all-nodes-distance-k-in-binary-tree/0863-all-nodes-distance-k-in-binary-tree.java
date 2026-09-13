/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //funtion to compute parent pointer refrence
    //Helper method to build the parent map using level-order traversal
    private void markParent(TreeNode root, HashMap<TreeNode, TreeNode> parent_track, TreeNode target){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left != null){
                parent_track.put(curr.left, curr);
                q.offer(curr.left);
            }
            if(curr.right != null){
                parent_track.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        //build parent pointer refrence using BFS(level order travesel)
        HashMap<TreeNode, TreeNode> parent_track = new HashMap<>();
        //call that funtion to compute parent pointer
        markParent(root, parent_track, root);
        //visited map that tell us this curr node`s root(parent), left / right chile is visited
        // BFS starting from the target node to collect nodes at distance K
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        //that Q store the actual ans
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visited.put(target, true);
        int curr_level = 0;
        //standers level-orderd BFS
        //seconed bfs to go upto k level from target node using our hastable info
        while(!q.isEmpty()){
            int size = q.size();
            //stop traversel once we reach distance k
            if(curr_level == k) break;
            curr_level++;
            for(int i = 0; i<size; i++){
                TreeNode current = q.poll();
                // Explore the left child
                if(current.left != null && visited.get(current.left) == null){
                    q.offer(current.left);
                    visited.put(current.left, true);
                }
                // Expolre the right child
                if(current.right != null && visited.get(current.right) == null){
                    q.offer(current.right);
                    visited.put(current.right, true);
                }
                // Explore the parent from the HashMap(parent_track)
                if(parent_track.get(current) != null && visited.get(parent_track.get(current)) == null){
                    q.offer(parent_track.get(current));
                    visited.put(parent_track.get(current), true);
                }
            }
        }
        //now q store th final ans
        // All nodes left(jo nodes bach jaye jab curr_level == k above while q  ko breack kar dega) in queue are exactly K distance from target
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode current = q.poll();
            ans.add(current.val);
        }
        return ans;


    }
}