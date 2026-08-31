// Problem: Palindrome Number
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/palindrome-number/
// Solved on: 2026-08-31T16:51:13.500Z

class Solution {
    public boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }

        int original = x;
        int pal = 0;

        while (x > 0) {
            int digit = x % 10;
            pal = pal * 10 + digit;
            x = x / 10;
        }

        return original == pal;
    }
}