# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        
        index = 0
        value = -1

        # Counterclock DFS
        def dfs(root: Optional[TreeNode], k: int):
            nonlocal index
            nonlocal value
            if not root:
                return False

            if dfs(root.left, k):
                return True

            index += 1
            if index == k:
                value = root.val
                return True

            if dfs(root.right, k):
                return True
        
        dfs(root, k)
        return value
