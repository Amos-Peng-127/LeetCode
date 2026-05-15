class Solution:
    def findMinDifference(self, timePoints: List[str]) -> int:
        
        def convert(t):
            h, m = t.split(':')
            return int(h) * 60 + int(m)
        t_mins = list(map(convert, timePoints))
        t_mins.sort()

        total_mins = 24 * 60

        min_diff = total_mins - t_mins[-1] + t_mins[0]

        for i in range(len(t_mins) - 1):
            clockwise = t_mins[i + 1] - t_mins[i]
            min_diff = min(min_diff, clockwise)

        return min_diff