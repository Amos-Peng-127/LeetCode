class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Brute Force
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         if (nums[i] == nums[j]) {
        //             return true;
        //         }
        //     }
        // }

        // return false;

        // Use set
        Set<Integer> numSet = new HashSet<>();

        for (int n: nums) {
            if (numSet.contains(n)) {
                return true;
            } else {
                numSet.add(n);
            }
        }

        return false;

        // Sorting
        // Arrays.sort(nums);

        // for (int i = 0; i < nums.length - 1; i++) {
        //     if (nums[i] == nums[i + 1]) {
        //         return true;
        //     }
        // }

        // return false;
    }
}