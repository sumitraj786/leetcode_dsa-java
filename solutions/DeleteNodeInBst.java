package solutions;

import javax.swing.tree.TreeNode;

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
 /* MY LOGIC:
same logic of using BFS traversal with queue (linkedList) and arrayLIst, just one more logic addition of evaluating each node present in the current queue because we want the result in form of list<list>> like nodes values at each level so on. Make sure to remember adding root to queue first out of the while loop in which we ue(!queue.isEmpty()), and the performing left and right addition of that node after popping the top node from queue.
 */
class DeleteNodeInBst {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return null;
        }

        if(key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if(key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            if(root.left == null && root.right == null) {
                return null;
            } else if(root.right == null) {
                return root.left;
            } else if(root.left == null) {
                return root.right;
            } else {
                TreeNode minNode = findMin(root.right);
                root.val = minNode.val;
                root.right = deleteNode(root.right, minNode.val);
            }
        }

        return root;
    }

    public TreeNode findMin(TreeNode root) {

        while(root.left != null) {
            root = root.left;
        }

        return root;
    }
}