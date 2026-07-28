class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;

        int l_max = 0;
        int r_max = 0;

        int out = 0;

        while (l < r) {
            
            if (height[l] > height[r]) {

                if (r_max > height[r]) {
                    out += r_max - height[r];
                } else {
                    r_max = height[r];
                }

                r--;

            } else {

                if (l_max > height[l]) {
                    out += l_max - height[l];
                } else {
                    l_max = height[l];
                }

                l++;
        
            }
        }

        return out;
    }
}