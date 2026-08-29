from functools import cache
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:

        @cache
        def dp(amount):
            if amount == 0:
                return 0

            if amount < 0:
                return -1

            res = float("inf")  # Number of Coin Needs

            for coin in coins:
                sub_prob = dp(amount - coin)
                
                if sub_prob != -1:
                    res = min(res, sub_prob + 1)

            return -1 if res == float("inf") else res

        return dp(amount)
