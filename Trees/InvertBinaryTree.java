/**
 * https://leetcode.com/problems/invert-binary-tree/
 */

 public InvertBinaryTree {
     public TreeNode invertTree(TreeNode root){
         if (root == null) return root;
         // DFS-like. Traverse until leaf
         TreeNode left = invertTree(root.left);
         TreeNode right = invertTree(root.right);

        // Swap
         root.left = right;
         root.right = left;

         return root;
     }
 }