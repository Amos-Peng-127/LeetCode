class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> seen = new HashMap<>();

        int l = 0;
        int r = 0;

        boolean valid = true;
        int max_out = 0;

        while (r < s.length()) {
            char r_char = s.charAt(r);
            r++;

            // seen.entrySet().stream().forEach(System.out::println);
            seen.put(r_char, seen.getOrDefault(r_char, 0) + 1);

            if (!seen.get(r_char).equals(0) && !seen.get(r_char).equals(1)) {
                valid = false;
            }

            while (!valid) {
                char l_char = s.charAt(l);
                l++;

                if (!seen.get(l_char).equals(0) && !seen.get(l_char).equals(1)) {
                    valid = true;
                }
                seen.put(l_char, seen.get(l_char) - 1);
            }

            if (valid) {
                max_out = Math.max(max_out, r - l);
            }
        }

        return max_out;
    }
}