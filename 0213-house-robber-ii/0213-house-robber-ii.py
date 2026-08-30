class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        
        if len(nums) == 2:
            return max(nums[0], nums[1])

        @cache
        def dp_rec(n, include_first):
            if n == 1 and include_first:
                return nums[0]

            if n == 1 and not include_first:
                return 0

            if n == 2 and include_first:
                return max(nums[0], nums[1])

            if n == 2 and not include_first:
                return nums[1]

            return max(
                dp_rec(n - 1, include_first),
                dp_rec(n - 2, include_first) + nums[n - 1]
            )
        
        # return dp_rec(len(nums), False)
        return max(
            nums[-1] + dp_rec(len(nums) - 2, False),
            dp_rec(len(nums) - 1, True)
        )