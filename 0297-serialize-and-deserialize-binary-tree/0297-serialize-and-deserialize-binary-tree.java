/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder s = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode currNode = q.poll();
            if(currNode == null){
                s.append("#").append(",");
            }
            else{
                s.append(currNode.val).append(",");
                q.offer(currNode.left);
                q.offer(currNode.right);

            }
        }
        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        String[] values = data.split(","); 
        //create a root node
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 1; // Already has 0 index root in q so start with 1
        while(!q.isEmpty() && i<values.length){
            TreeNode node = q.poll(); //intially we get a root node (root == node)
            // Read yhe Left child Value
            if(!values[i].equals("#")){
                TreeNode Leftnode = new TreeNode(Integer.parseInt(values[i]));
                node.left = Leftnode;
                q.offer(Leftnode); //in build a string we frist build root -> left -> right and # -> pointtonull  to build a ans(s) string or we said that frist we put root string then call the leftchild and rightchild so that is why Here we frist call the left , in above we also crate root then left and then right 
            }
            i++;
            // Read the Right value
            if(!values[i].equals("#")){
                TreeNode Rightnode = new TreeNode(Integer.parseInt(values[i]));
                node.right = Rightnode;
                q.offer(Rightnode);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));