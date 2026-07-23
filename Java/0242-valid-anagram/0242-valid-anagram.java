class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        // Sort

        // char[] charS = s.toCharArray();
        // char[] charT = t.toCharArray();

        // Arrays.sort(charS);
        // Arrays.sort(charT);

        // return Arrays.equals(charS, charT);

        // Hash Map
        // HashMap<Character, Integer> countS = new HashMap<>();
        // HashMap<Character, Integer> countT = new HashMap<>();

        // for (int i = 0; i < s.length(); i++) {
        //     countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0) + 1);
        //     countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);
        // }
        
        // return countS.equals(countT);

        // Hash Table
        // int[] count = new int[26];

        // for (int i = 0; i < s.length(); i++) {
        //     count[s.charAt(i) - 'a']++;
        //     count[t.charAt(i) - 'a']--;
        // }

        // for (int val : count) {
        //     if (val != 0) {
        //         return false;
        //     }
        // }

        // return true;

        // Hash Table Advanced
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (char c : t.toCharArray()) {
            if (count[c - 'a'] <= 0) {
                return false;
            }
            count[c - 'a']--;
        }

        return true;
    }
}