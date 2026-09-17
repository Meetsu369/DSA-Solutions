// Problem: Generate Parentheses
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/generate-parentheses/
// Solved on: 2026-09-17T18:25:56.959Z

import java.util.*;

class Solution {

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();

        StringBuilder current = new StringBuilder();

        backtrack(n, 0, 0, current, result);

        return result;
    }

    private void backtrack(
        int n,
        int open,
        int close,
        StringBuilder current,
        List<String> result
    ) {

        if (open == n && close == n) {
            result.add(current.toString());
            return;
        }

        if (open < n) {

            current.append('(');

            backtrack(
                n,
                open + 1,
                close,
                current,
                result
            );

            current.deleteCharAt(current.length() - 1);
        }

        if (close < open) {

            current.append(')');

            backtrack(
                n,
                open,
                close + 1,
                current,
                result
            );

            current.deleteCharAt(current.length() - 1);
        }
    }
}