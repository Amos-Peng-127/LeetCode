class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Hash Map
        Map<Integer, Integer> count = new HashMap<>();

        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        // System.out.println(count);
        ArrayList<int[]> count_List = new ArrayList<>();

        count.forEach((key, value) -> {
            count_List.add(new int[]{key, value});
        });
        // System.out.println(count_List);
        // count_List.stream().map(Arrays::toString).forEach(System.out::println);
        count_List.sort((a, b) -> b[1] - a[1]);
        return count_List.stream().limit(k).mapToInt(arr -> arr[0]).toArray();
    }
}