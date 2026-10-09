
class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int open = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                // If an unmatched ')' is pending, insert one ')'
                if (open > 0 && open % 2 != 0) {
                    insertions++;
                    open--;
                }

                open += 2;
            } else {
                open--;

                // No opening parentheses available
                if (open < 0) {
                    insertions++;
                    open = 1;
                }
            }
        }

        return insertions + open;
    }
}
