class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        
        # n Represent the Stair Needs to Be at the End
        @cache
        def dp_rec(n):
            if n == 0 or n == 1:
                return 0

            steps = min(dp_rec(n - 1) + cost[n - 1], dp_rec(n - 2) + cost[n - 2])

            return steps

        return dp_rec(len(cost))