class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        prev_min = float('inf')
        out = -float('inf')

        for p in prices:
            print(prev_min, p)
            curr_diff = p - prev_min
            out = max(curr_diff, out)
            prev_min = min(prev_min, p)

        return out if out >= 0 else 0