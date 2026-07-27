class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;

        int max_out = 0;

        while (l < r) {
            int curr_min_height = Math.min(height[l], height[r]);

            max_out = Math.max(max_out, curr_min_height * (r - l));

            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }

        return max_out;
    }
}