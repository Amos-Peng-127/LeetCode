class Solution:
    def climbStairs(self, n: int) -> int:
        
        # Base Case
        # f(1) = 1, f(2) = 2 -> f(3) = f(1) + f(2)

        # State Transition Function
        # f(n) = f(n - 1) and f(n - 2)

        # DP Table
        if n == 1 or n == 2:
            return n

        n1, n2 = 1, 2
        for i in range(n - 2):
            n1, n2 = n2, n1 + n2
        
        return n2

        # # Recurrsion
        # if n == 1 or n == 2:
        #     return n
        
        # return self.climbStairs(n - 1) + self.climbStairs(n - 2)