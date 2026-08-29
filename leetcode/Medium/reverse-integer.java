// Problem: Reverse Integer
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/reverse-integer/
// Solved on: 2026-08-29T18:17:47.769Z

class Solution {
    public int reverse(int x) {

        int result = 0;

        while (x != 0) {

            int digit = x % 10;
            x /= 10;

            if (result > Integer.MAX_VALUE / 10 ||
                (result == Integer.MAX_VALUE / 10 &&
                 digit > Integer.MAX_VALUE % 10) ||
                result < Integer.MIN_VALUE / 10 ||
                (result == Integer.MIN_VALUE / 10 &&
                 digit < Integer.MIN_VALUE % 10)) {

                return 0;
            }

            result = result * 10 + digit;
        }

        return result;
    }
}