class Solution {
    static final long MOD = 1_000_000_007L;

    class SegmentTree {
        int n;
        long[] sum;
        long[] squareSum;
        long[] lazy;

        SegmentTree(int n) {
            this.n = n;
            sum = new long[4 * n];
            squareSum = new long[4 * n];
            lazy = new long[4 * n];
        }

        void apply(int node, int left, int right, long val) {
            long len = right - left + 1L;

            squareSum[node] = (
                squareSum[node]
                + 2 * val % MOD * sum[node] % MOD
                + len * val % MOD * val % MOD
            ) % MOD;

            sum[node] = (sum[node] + len * val) % MOD;
            lazy[node] = (lazy[node] + val) % MOD;
        }

        void pushDown(int node, int left, int right) {
            if (lazy[node] == 0 || left == right) {
                return;
            }

            int mid = left + (right - left) / 2;

            apply(node * 2, left, mid, lazy[node]);
            apply(node * 2 + 1, mid + 1, right, lazy[node]);

            lazy[node] = 0;
        }

        void update(int node, int left, int right,
                    int ql, int qr) {
            if (ql > right || qr < left) {
                return;
            }

            if (ql <= left && right <= qr) {
                apply(node, left, right, 1);
                return;
            }

            pushDown(node, left, right);

            int mid = left + (right - left) / 2;

            update(node * 2, left, mid, ql, qr);
            update(node * 2 + 1, mid + 1, right, ql, qr);

            sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;

            squareSum[node] = (
                squareSum[node * 2] + squareSum[node * 2 + 1]
            ) % MOD;
        }

        void update(int left, int right) {
            if (left <= right) {
                update(1, 0, n - 1, left, right);
            }
        }

        long getSquareSum() {
            return squareSum[1];
        }
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;
        SegmentTree tree = new SegmentTree(n);

        int[] last = new int[100001];
        java.util.Arrays.fill(last, -1);

        long answer = 0;

        for (int i = 0; i < n; i++) {
            int previous = last[nums[i]];

            tree.update(previous + 1, i);

            answer = (answer + tree.getSquareSum()) % MOD;

            last[nums[i]] = i;
        }

        return (int) answer;
    }
}