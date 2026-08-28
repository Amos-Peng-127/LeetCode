# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
        def dfs(root, low_bound, high_bound):
            
            if not root:
                return True

            if root.val <= low_bound or root.val >= high_bound:
                return False

            left_BST = dfs(root.left, low_bound, root.val)

            right_BST = dfs(root.right, root.val, high_bound)
            
            return left_BST and right_BST
        
        return dfs(root, -float('inf'), float('inf'))
            