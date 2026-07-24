class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Sorting
        int[] origin = nums.clone();
        Arrays.sort(nums);
        
        int left_pointer = 0;
        int right_pointer = nums.length - 1;

        while (left_pointer < right_pointer) {

            if (nums[left_pointer] + nums[right_pointer] == target) {
                int out1 = -1;
                int out2 = -1;

                for (int i = 0; i < nums.length; i++) {

                    if (origin[i] == nums[left_pointer] && out1 == -1) {
                        out1 = i;
                        continue;
                    }

                    if (origin[i] == nums[right_pointer] && out2 == -1) {
                        out2 = i;
                    }
                }
                return new int[]{out1, out2};

            } else if (nums[left_pointer] + nums[right_pointer] < target) {
                left_pointer++;

            } else if (nums[left_pointer] + nums[right_pointer] > target) {
                right_pointer--;
            }
        }

        return new int[0];
        
        // // HashMap
        // Map<Integer, Integer> map = new HashMap<>();

        // for (int i = 0; i < nums.length; i++) {
        //     map.put(nums[i], i);
        // }

        // for (int i = 0; i < nums.length; i++) {
        //     if (map.containsKey(target - nums[i]) && (map.get(target - nums[i]) != i)) {
        //         return new int[]{i, map.get(target - nums[i])};
        //     }
        // }

        // return new int[]{};
    }
}