import bisect
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        top = []

        for i in range(len(nums)):

            # Use Bisect Method Instead of Divide Conque
            left_index = bisect.bisect_left(
                top, nums[i], 
            )
            
            if left_index == len(top):
                top.append(nums[i])
            else:
                top[left_index] = nums[i]

            # replace = -1

            # # Use Manual Divide Conque to Search
            # l, r = 0, len(top) - 1
            # while l <= r:
            #     mid = (l + r) // 2

            #     if top[mid] == nums[i]:
            #         replace = mid
            #         break
            #     elif top[mid] > nums[i]:
            #         replace = mid
            #         r = mid - 1 
            #     else:
            #         l = mid + 1

            # if replace == -1:
            #     top.append(nums[i])
            # else:
            #     top[replace] = nums[i]

        
        return len(top)
            
