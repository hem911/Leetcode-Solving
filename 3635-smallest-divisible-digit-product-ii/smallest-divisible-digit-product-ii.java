import java.util.*;

class Solution {

    private static final Map<Integer, Map<Integer, Integer>> FACTOR_COUNTS = Map.of(
            0, Map.of(),
            1, Map.of(),
            2, Map.of(2, 1),
            3, Map.of(3, 1),
            4, Map.of(2, 2),
            5, Map.of(5, 1),
            6, Map.of(2, 1, 3, 1),
            7, Map.of(7, 1),
            8, Map.of(2, 3),
            9, Map.of(3, 2)
    );

    public String smallestNumber(String num, long t) {

        PrimeResult result = getPrimeCount(t);

        if (!result.valid)
            return "-1";

        Map<Integer, Integer> needDigits = getFactorCount(result.primes);

        if (sumValues(needDigits) > num.length())
            return construct(needDigits);

        Map<Integer, Integer> prefix = getPrimeCount(num);

        int firstZero = num.indexOf('0');

        if (firstZero == -1) {
            firstZero = num.length();
            if (isSubset(result.primes, prefix))
                return num;
        }

        for (int i = num.length() - 1; i >= 0; i--) {

            int d = num.charAt(i) - '0';

            prefix = subtract(prefix, FACTOR_COUNTS.get(d));

            int space = num.length() - i - 1;

            if (i > firstZero)
                continue;

            for (int nd = d + 1; nd <= 9; nd++) {

                Map<Integer, Integer> remain =
                        getFactorCount(
                                subtract(
                                        subtract(result.primes, prefix),
                                        FACTOR_COUNTS.get(nd)
                                )
                        );

                int used = sumValues(remain);

                if (used <= space) {

                    int ones = space - used;

                    return num.substring(0, i)
                            + nd
                            + "1".repeat(ones)
                            + construct(remain);
                }
            }
        }

        Map<Integer, Integer> remain = getFactorCount(result.primes);

        return "1".repeat(num.length() + 1 - sumValues(remain))
                + construct(remain);
    }

    // ----------------------------------------------------

    static class PrimeResult {
        Map<Integer, Integer> primes;
        boolean valid;

        PrimeResult(Map<Integer, Integer> p, boolean v) {
            primes = p;
            valid = v;
        }
    }

    private PrimeResult getPrimeCount(long t) {

        Map<Integer, Integer> map = new HashMap<>();

        map.put(2, 0);
        map.put(3, 0);
        map.put(5, 0);
        map.put(7, 0);

        int[] primes = {2, 3, 5, 7};

        for (int p : primes) {
            while (t % p == 0) {
                t /= p;
                map.put(p, map.get(p) + 1);
            }
        }

        return new PrimeResult(map, t == 1);
    }

    private Map<Integer, Integer> getPrimeCount(String num) {

        Map<Integer, Integer> map = new HashMap<>();

        map.put(2, 0);
        map.put(3, 0);
        map.put(5, 0);
        map.put(7, 0);

        for (char c : num.toCharArray()) {

            Map<Integer, Integer> f = FACTOR_COUNTS.get(c - '0');

            for (Map.Entry<Integer, Integer> e : f.entrySet()) {
                map.put(e.getKey(), map.get(e.getKey()) + e.getValue());
            }
        }

        return map;
    }

    private Map<Integer, Integer> subtract(
            Map<Integer, Integer> a,
            Map<Integer, Integer> b) {

        Map<Integer, Integer> res = new HashMap<>(a);

        for (Map.Entry<Integer, Integer> e : b.entrySet()) {
            int key = e.getKey();
            res.put(key, Math.max(0, res.get(key) - e.getValue()));
        }

        return res;
    }

    private boolean isSubset(
            Map<Integer, Integer> need,
            Map<Integer, Integer> have) {

        for (Map.Entry<Integer, Integer> e : need.entrySet()) {
            if (have.get(e.getKey()) < e.getValue())
                return false;
        }

        return true;
    }

    private int sumValues(Map<Integer, Integer> map) {

        int ans = 0;

        for (int v : map.values())
            ans += v;

        return ans;
    }

    private String construct(Map<Integer, Integer> map) {

        StringBuilder sb = new StringBuilder();

        for (int d = 2; d <= 9; d++) {

            int cnt = map.getOrDefault(d, 0);

            while (cnt-- > 0)
                sb.append(d);
        }

        return sb.toString();
    }

    private Map<Integer, Integer> getFactorCount(Map<Integer, Integer> cnt) {

        int eight = cnt.get(2) / 3;
        int rem2 = cnt.get(2) % 3;

        int nine = cnt.get(3) / 2;
        int three = cnt.get(3) % 2;

        int four = rem2 / 2;
        int two = rem2 % 2;

        int six = 0;

        if (two == 1 && three == 1) {
            two = 0;
            three = 0;
            six = 1;
        }

        if (three == 1 && four == 1) {
            two = 1;
            six = 1;
            three = 0;
            four = 0;
        }

        Map<Integer, Integer> res = new HashMap<>();

        res.put(2, two);
        res.put(3, three);
        res.put(4, four);
        res.put(5, cnt.get(5));
        res.put(6, six);
        res.put(7, cnt.get(7));
        res.put(8, eight);
        res.put(9, nine);

        return res;
    }
}