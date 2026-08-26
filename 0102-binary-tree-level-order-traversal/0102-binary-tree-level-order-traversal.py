# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []

        out = []

        def bfs(current_level_node: Optional[List[TreeNode]]):
                
            if len(current_level_node) == 0:
                return

            # Convert Node into Val List and Store to Output 
            out.append([node.val for node in current_level_node])

            # Store Next Level Node
            next_level_node = []
            
            for node in current_level_node:
                if node.left:
                    next_level_node.append(node.left)
                if node.right:
                    next_level_node.append(node.right)
            
            bfs(next_level_node)

        bfs([root])

        return out