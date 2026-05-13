class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # prev_min = float('inf')
        # out = -float('inf')

        # for p in prices:
        #     print(prev_min, p)
        #     curr_diff = p - prev_min
        #     out = max(curr_diff, out)
        #     prev_min = min(prev_min, p)

        # return out if out >= 0 else 0

        low = prices[0]
        high = prices[0]
        res = 0
        for price in prices:
            if price < low:
                low = price
                high = price
            elif price > high:
                high = price
                res = max(res, high - low)
        return res