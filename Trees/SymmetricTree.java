import java.util.Queue;

import javax.swing.tree.TreeNode;

/**
 * https://leetcode.com/problems/symmetric-tree/
 */

public class SymmetricTree{
    /**
     * Approach 1: Recursive
     * Time Complexity: O(n) because we traverse tree once, n is total number of nodes in tree
     * Space Complexity: O(n) because worst case, tree is linear and height is O(n).
     */
    public boolean isSymmetricRecursive(TreeNode root){
        
        return isMirror(root, root);
    }
    public boolean isMirror(TreeNode t1, TreeNode t2){
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val) && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
    }

    /**
     * Approach 2: Iterative
     * Time Complexity: O(n) because we traverse entire tree
     * Space Complexity: O(n) because worst case we insert entire tree in queue
     */
    public boolean isSymmetricIterative(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()){
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            // Each consecutive node in queue should be equal
            if (t1.val != t2.val) return false;
            // Right and left children of two nodes are inserted in queue in opposite order.
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        // If queue is empty, tree is symmetric
        return true;
    }

}