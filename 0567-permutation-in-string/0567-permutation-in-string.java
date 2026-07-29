class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> seen = new HashMap<>();

        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
            seen.put(c, 0);
        }

        int l = 0;
        int r = s1.length();
        int valid = 0;

        // need.entrySet().stream().forEach(System.out::println);
        // seen.entrySet().stream().forEach(System.out::println);
        // System.out.println(valid);

        for (int i = 0; i < r; i++) {
            char d = s2.charAt(i);
            if (need.containsKey(d)) {
                seen.put(d, seen.getOrDefault(d, 0) + 1);
                if (seen.get(d).equals(need.get(d))) {
                    valid++;
                }
            }
        }

        if (valid == need.size()) return true;

        while (r < s2.length()) {
            // System.out.println(l);
            // System.out.println(r);
            // System.out.println(valid);
            
            char right_c = s2.charAt(r);
            r++;

            if (need.containsKey(right_c)) {
                seen.put(right_c, seen.get(right_c) + 1);
                if (seen.get(right_c).equals(need.get(right_c))) {
                    valid++;
                }
            }

            char left_c = s2.charAt(l);
            l++;

            if (need.containsKey(left_c)) {
                if (seen.get(left_c).equals(need.get(left_c))) {
                    valid--;
                }
                seen.put(left_c, seen.get(left_c) - 1);
            }

            if (valid == need.size()) return true;

            // System.out.println(l);
            // System.out.println(r);
            // System.out.println(valid);
            // need.entrySet().stream().forEach(System.out::println);
            // seen.entrySet().stream().forEach(System.out::println);
        }
        return false;

    }
}