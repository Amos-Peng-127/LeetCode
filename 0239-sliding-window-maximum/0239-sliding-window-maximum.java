class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int[] out = new int[nums.length - k + 1];

        Deque<Integer> q = new LinkedList<>();

        while (r < nums.length) {
            while (!q.isEmpty() && nums[r] > nums[q.getLast()]) {
                q.removeLast();
            }

            q.addLast(r);

            if (q.getFirst() < l) {
                q.removeFirst();
            }

            if (r + 1 >= k) {
                out[l] = nums[q.getFirst()];
                l++;
            }

            r++;
        }
        return out;
    }
}