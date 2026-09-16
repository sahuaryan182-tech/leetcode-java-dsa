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
    //datatpe , varible name difine kara hai sub class , ke variable Recusion call  main use honge, each call knows , where they left the value in last recursion call
    private TreeNode frist;
    private TreeNode last;
    private TreeNode middle;
    private TreeNode prev;

    private void inorder(TreeNode root){
        if(root == null) return;
        //gose to left in Inorder
        inorder(root.left);

        if(prev != null && prev.val > root.val){

            if(frist == null){
                //if this is frist voilation, mark these two nodes as
                //currnode (root.val) -> middle
                //prev(node) -> frist
                middle = root;
                frist = prev;
            }
        
            // if this is second voilation, mark this currentNode(root.val) as last node
            else{
                last = root;
            }
        }

        // Update the prev(node) in order to move and compare the currnode value
        ///mark this currnode(root) as a privious 
        prev = root;


        //gose to right in Inorder
        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        // intiallize kara variable value ko
        frist = null;
        last = null;
        middle = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);

        //if Seconed voilation happen Swap only frist and last
        if(frist != null && last != null){
            int t = frist.val;
            frist.val = last.val;
            last.val  = t;
        }

        //if only one voilation happen then Swap only frist and middle
        else if(frist != null && middle != null){
            int t = frist.val;
            frist.val = middle.val;
            middle.val = t;
        }
    }
}