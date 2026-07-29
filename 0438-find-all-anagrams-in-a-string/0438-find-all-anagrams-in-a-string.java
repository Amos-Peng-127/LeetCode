class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) return new ArrayList<>();

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> seen = new HashMap<>();

        int l = 0;
        int r = p.length();
        int valid = 0;
        int count = 0;

        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
            seen.put(c, 0);
        }

        for (int i = 0; i < p.length(); i++) {
            char d = s.charAt(i);
            if (need.containsKey(d)) {
                seen.put(d, seen.get(d) + 1);
                if (seen.get(d).equals(need.get(d))) {
                    valid++;
                }
            }
        }

        List<Integer> out = new ArrayList<>();

        if (valid == need.size()) out.add(0);

        while (r < s.length()) {
            // System.out.println(l);
            // System.out.println(r);
            // need.entrySet().stream().forEach(System.out::println);
            // seen.entrySet().stream().forEach(System.out::println);

            char right_c = s.charAt(r);
            r++;

            if (need.containsKey(right_c)) {
                seen.put(right_c, seen.get(right_c) + 1);
                if (seen.get(right_c).equals(need.get(right_c))) {
                    valid++;
                }
            }

            char left_c = s.charAt(l);
            l++;

            if (need.containsKey(left_c)) {
                if (seen.get(left_c).equals(need.get(left_c))) {
                    valid--;
                }
                seen.put(left_c, seen.get(left_c) - 1);
            }

            if (valid == need.size()) out.add(l);
        }

        return out;
    }
}