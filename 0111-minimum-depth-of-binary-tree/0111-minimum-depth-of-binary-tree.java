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
    public int minDepth(TreeNode root) {
        
        // BFS
        if (root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int depth = 1;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr_node = q.poll();

                if (curr_node.left == null && curr_node.right == null) {
                    return depth;
                }

                if (curr_node.left != null) q.offer(curr_node.left);
                if (curr_node.right != null) q.offer(curr_node.right);
            }

            depth++;
        }

        return depth;

        // // DFS
        // if (root == null) return 0;

        // int left = minDepth(root.left);
        // int right = minDepth(root.right);

        // if (left == 0 && right != 0) {
        //     return 1 + right;
        // } else if (left != 0 && right == 0) {
        //     return 1 + left;
        // } else if (left != 0 && right != 0) {
        //     return 1 + Math.min(left, right);
        // } else {
        //     return 1;
        // }

    }
}