// Problem: Valid Parentheses
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/valid-parentheses/
// Solved on: 2026-09-17T18:23:26.660Z

import java.util.*;

class Solution {
    public boolean isValid(String s) {

        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {

            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }

            else {

                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if ((ch == ')' && top != '(') ||
                    (ch == ']' && top != '[') ||
                    (ch == '}' && top != '{')) {

                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}