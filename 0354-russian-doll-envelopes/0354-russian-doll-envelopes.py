import bisect
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        
        # Sort Ascending by Width and Descending by Height
        envelopes.sort(key = lambda x: (x[0], -x[1]))

        # After Width has been Sorted, Store Height in Separate List
        heights = [x[1] for x in envelopes]

        # Perform LIS (Longest Increasing Sequencing)
        return self.LIS(heights)
    
    def LIS(self, nums: List[int]) -> int:
        
        # Create Top Piles to Store Num
        top = []

        for n in nums:
            
            left_replace = bisect.bisect_left(top, n)
            
            if left_replace == len(top):
                top.append(n)
            else:
                top[left_replace] = n
            
        return len(top)