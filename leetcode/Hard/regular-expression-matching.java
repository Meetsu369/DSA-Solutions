// Problem: Regular Expression Matching
// Platform: leetcode
// Rating/Difficulty: Hard
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/regular-expression-matching/
// Solved on: 2026-09-01T15:59:46.398Z

class Solution {
    Boolean[][] memo;
    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length() + 1][p.length() + 1];
        return solve(s, p, 0, 0);
    }
    private boolean solve(String s, String p, int i, int j) {
        if (j == p.length()) {
            return i == s.length();
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        boolean firstMatch =
                i < s.length() &&
                (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        boolean result;
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            result =
                solve(s, p, i, j + 2) ||
                (firstMatch && solve(s, p, i + 1, j));

        } else {
            result =
                firstMatch &&
                solve(s, p, i + 1, j + 1);
        }
        memo[i][j] = result;
        return result;
    }
}