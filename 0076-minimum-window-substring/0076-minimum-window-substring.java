class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> seen = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
            seen.put(c, 0);
        }


        int l = 0;
        int r = 0;
        int min_left = 0;
        int min_len = Integer.MAX_VALUE;
        int valid = 0;

        // need.entrySet().stream().forEach(System.out::println);
        // seen.entrySet().stream().forEach(System.out::println);
        while (r < s.length()) {
            char right_c = s.charAt(r);
            r++;
            
            if (need.containsKey(right_c)) {

                seen.put(right_c, seen.get(right_c) + 1);
                if (need.get(right_c).equals(seen.get(right_c))) {
                    valid++;
                }
            }

            while (valid == need.size()) {

                if (r - l < min_len) {
                    min_left = l;
                    min_len = r - l;
                }

                char left_c = s.charAt(l);
                l++;

                if (need.containsKey(left_c)) {
                    if (need.get(left_c).equals(seen.get(left_c))) {
                        valid--;
                    }
                    seen.put(left_c, seen.get(left_c) - 1);
                }
            }
        }

        return min_len == Integer.MAX_VALUE ? "" : s.substring(min_left, min_left + min_len);
    }
}