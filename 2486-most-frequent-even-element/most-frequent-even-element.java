class Solution {
    public int mostFrequentEven(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                max = Math.max(max, map.get(nums[i]));
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                return entry.getKey();
            }
        }
        return -1;

    }
}