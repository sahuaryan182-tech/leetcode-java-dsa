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
    //stire the informations aboute the node
    //define the each node information
    static class Pair{
        int col; //vertical colum
        int row; //row coloum
        int value; //nodes value

        Pair(int col, int row, int value){
            this.col = col;
            this.row = row;
            this.value = value;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Pair> nodes = new ArrayList<>(); //the pair of nodes (0,0,1)

        //collect the noode 
        dfs(root, 0, 0, nodes);

        // Sort:
        // 1. Smaller column first -> leftmost col(vertical -> -1, 0, 1,2) comses frist
        // 2. Smaller row first -> is two nodes in same colume ,  upper node(lower level) comes frist(row -> 0 , row -> 1, row , -> 2)
        // 3. Smaller value first -> is two nodes in same col and sam row , the samller value comes frist
        Collections.sort(nodes, (a, b) -> {
            if(a.col != b.col){
                return a.col - b.col; 
            }

            if(a.row != b.row){
                return a.row - b.row;
            }

            return a.value - b.value;
        });

        //final ans store
        List<List<Integer>> ans = new ArrayList<>();
        //remember privious nodes col
        int previousCol = Integer.MIN_VALUE;

        //create vertical columes
        for( Pair p : nodes){
            //new colume
            if(p.col != previousCol){
                ans.add(new ArrayList<>());
                previousCol = p.col;
            }
            //add node to current colum 
            ans.get(ans.size()-1).add(p.value);
        }
        return ans;

    }
    private void dfs(TreeNode node, int col, int row, List<Pair> nodes){
        if(node == null) return;
        //store the nodes
        nodes.add(new Pair(col, row, node.val));
        //if left chile exist 
        dfs(node.left, col-1, row+1, nodes);
        //if right child exist
        dfs(node.right, col+1, row+1, nodes);
    }
}