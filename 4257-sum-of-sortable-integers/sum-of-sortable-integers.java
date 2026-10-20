
class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;

        int[] prefixMax = new int[n + 1];
        int[] suffixMin = new int[n + 1];
        int[] prefixDrop = new int[n];

        for (int i = 0; i < n; i++) {
            prefixMax[i + 1] = Math.max(prefixMax[i], nums[i]);
        }

        suffixMin[n] = Integer.MAX_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]);
        }

        for (int i = 1; i < n; i++) {
            prefixDrop[i] = prefixDrop[i - 1];

            if (nums[i - 1] > nums[i]) {
                prefixDrop[i]++;
            }
        }

        int answer = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }

            boolean valid = true;

            for (int start = 0; start < n; start += k) {
                int end = start + k - 1;

                int drops = prefixDrop[end] - prefixDrop[start];

                if (nums[end] > nums[start]) {
                    drops++;
                }

                if (drops > 1 || prefixMax[start] > suffixMin[start]) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                answer += k;
            }
        }

        return answer;
    }
}
