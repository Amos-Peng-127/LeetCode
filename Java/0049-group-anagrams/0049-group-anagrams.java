class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 1) {
            return List.of(List.of(strs[0]));
        }
        Map<List<String>, List<String>> map = new HashMap<>();

        for (String str : strs) {
            List<String> chars = new ArrayList<>(Arrays.asList(str.split("")));
            chars.sort((a, b) -> a.compareTo(b));

            if (!map.containsKey(chars)) {
                map.put(chars, new ArrayList<String>());
            }
            map.get(chars).add(str);
        }

        return new ArrayList<>(map.values());
    }
}