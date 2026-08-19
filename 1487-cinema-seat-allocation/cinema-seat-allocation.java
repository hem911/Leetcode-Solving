import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        
        Map<Integer, Integer> map = new HashMap<>();

        // Store reserved seats as a bitmask for each row
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            // Only seats 2 to 9 matter
            if (col >= 2 && col <= 9) {
                map.put(row, map.getOrDefault(row, 0) | (1 << col));
            }
        }

        // Rows with no reserved seats can fit 2 families
        int result = (n - map.size()) * 2;

        // Masks for the three possible family groups
        int left  = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5);
        int middle = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7);
        int right = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9);

        for (int mask : map.values()) {

            if ((mask & (left | right)) == 0) {
                // Both left and right groups are available
                result += 2;
            } 
            else if ((mask & left) == 0 || 
                     (mask & middle) == 0 || 
                     (mask & right) == 0) {
                // At least one group is available
                result += 1;
            }
        }

        return result;
    }
}