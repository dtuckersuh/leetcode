/**
 * Return the root node of a binary search tree that matches the given preorder traversal.
 */
public class ConstructBinarySearchTreeFromPreorder {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++){
            TreeNode curr = new TreeNode(preorder[i]);
            constructTree(root, curr);
        }
        return root;
    }
    
    public void constructTree(TreeNode root, TreeNode curr){
        if (curr.val < root.val){
            if (root.left != null){
                constructTree(root.left, curr);
            } else {
                root.left = curr;    
            }
        } else {
            if (root.right != null){
                constructTree(root.right, curr);
            } else {
                root.right = curr;    
            }
        }
    }
}