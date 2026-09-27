// Problem: Longest Valid Parentheses
// Platform: leetcode
// Rating/Difficulty: Unrated
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/longest-valid-parentheses/
// Solved on: 2026-09-27T17:14:11.613Z

class Solution {
    public int longestValidParentheses(String s) {

        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(-1);

        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {

                stack.push(i);

            } else {

                stack.pop();

                if (stack.isEmpty()) {

                    stack.push(i);
                } else {

                    int length = i - stack.peek();
                    maxLength = Math.max(maxLength, length);
                }
            }
        }

        return maxLength;
    }
}