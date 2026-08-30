class Solution:
    def rob(self, nums: List[int]) -> int:
        @cache
        def dp_rec(n):
            if n == 1:
                return nums[0]
            
            if n == 2:
                return max(nums[0], nums[1])

            return max(nums[n - 1] + dp_rec(n - 2), dp_rec(n - 1))

        return dp_rec(len(nums))