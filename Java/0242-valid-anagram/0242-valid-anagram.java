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
        HashMap<Character, Integer> countS = new HashMap<>();
        HashMap<Character, Integer> countT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0) + 1);
            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);
        }
        
        return countS.equals(countT);
    }
}