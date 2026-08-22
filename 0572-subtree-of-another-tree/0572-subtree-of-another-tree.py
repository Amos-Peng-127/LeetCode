# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def isSameTree(
        self,
        r1: Optional[TreeNode],
        r2: Optional[TreeNode]
    ) -> bool:
        if r1 is None and r2 is None:
            return True
        
        if r1 is None or r2 is None or r1.val != r2.val:
            return False

        return self.isSameTree(r1.left, r2.left) and self.isSameTree(r1.right, r2.right)
    
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        
        if root is None:
            return False
        
        if root.val == subRoot.val:
            if self.isSameTree(root, subRoot):
                return True

        if root.left is not None and root.left.val == subRoot.val:
            if self.isSameTree(root.left, subRoot):
                return True
        
        if root.right is not None and root.right.val == subRoot.val:
            if self.isSameTree(root.right, subRoot):
                return True

        left = False
        right = False

        if root.left:
            left = self.isSubtree(root.left, subRoot)

        if root.right:
            right = self.isSubtree(root.right, subRoot)

        return left or right
        