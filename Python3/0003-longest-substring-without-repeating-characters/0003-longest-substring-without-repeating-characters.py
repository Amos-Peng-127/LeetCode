class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        left_pointer = 0
        char_set = set()
        max_len = 0

        for right_pointer in range(len(s)):

            while s[right_pointer] in char_set:
                char_set.remove(s[left_pointer])
                left_pointer += 1

            char_set.add(s[right_pointer])
            
            max_len = max(max_len, right_pointer - left_pointer + 1)
        return max_len