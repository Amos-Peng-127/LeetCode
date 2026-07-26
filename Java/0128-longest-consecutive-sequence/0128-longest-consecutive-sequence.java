class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> seen = new HashSet<>();

        for (int n : nums) {
            seen.add(n);
        }

        int out = 1;

        for (int n : seen) {
            if (!seen.contains(n - 1)){
                int current_max = 1;
                while (seen.contains(n + current_max)) {
                    current_max++;
                }
                out = Math.max(out, current_max);
            }
        }

        return out;
    }
}