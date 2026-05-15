class Solution:
    def findMinDifference(self, timePoints: List[str]) -> int:
        
        t_mins = [False for _ in range(24 * 60)]

        def convert(t):
            h, m = t.split(':')
            return int(h) * 60 + int(m)
        
        for t in timePoints:
            if t_mins[convert(t)]:
                return 0
            t_mins[convert(t)] = True

        prev_seen = None
        first_seen = None
        last_seen = None
        min_diff = float('inf')

        for i in range(1440):
            if t_mins[i]:
                last_seen = i
                if prev_seen == None:
                    prev_seen = i
                    first_seen = i
                    continue
                min_diff = min(min_diff, i - prev_seen)
                prev_seen = i

        min_diff = min(min_diff, 1440 - (last_seen - first_seen))

        return min_diff


        # # Time Complexity O(nlog(n)), Space Complexity O(n)
        # def convert(t):
        #     h, m = t.split(':')
        #     return int(h) * 60 + int(m)
        # t_mins = list(map(convert, timePoints))
        # t_mins.sort()

        # total_mins = 24 * 60

        # min_diff = total_mins - t_mins[-1] + t_mins[0]

        # for i in range(len(t_mins) - 1):
        #     clockwise = t_mins[i + 1] - t_mins[i]
        #     min_diff = min(min_diff, clockwise)

        # return min_diff