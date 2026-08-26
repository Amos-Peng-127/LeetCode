# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# from collections import deque
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []

        out = []

        current_level_node = [root]

        while len(current_level_node) > 0:
            # Append the Value of Most Right Side Node in Current Level
            out.append(current_level_node[-1].val)

            # Create Container for Nodes in Next Level
            next_level_node = []

            # Iter and Store in Order
            for node in current_level_node:
                if node.left:
                    next_level_node.append(node.left)
                if node.right:
                    next_level_node.append(node.right)
            
            current_level_node = next_level_node
        
        return out