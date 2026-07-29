class Solution {
    public int characterReplacement(String s, int k) {
        int[] seen = new int[26];

        int l = 0;
        int r = 0;
        int max_freq = 0;
        int out_max = 0;

        while (r < s.length()) {
            char r_char = s.charAt(r);
            r++;

            seen[r_char - 'A']++;
            max_freq = Math.max(max_freq, seen[r_char - 'A']);

            while (r - l - max_freq > k) {
                char l_char = s.charAt(l);
                seen[l_char - 'A']--;
                l++;
            }

            out_max = Math.max(out_max, r - l);
        }
        return out_max;
    }
}