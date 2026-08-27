// Problem: Longest Palindromic Substring
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/longest-palindromic-substring/
// Solved on: 2026-08-27T18:10:13.559Z

class Solution {

    public int expandAroundCenter(String s, int left, int right) {

        while (left >= 0 &&
               right < s.length() &&
               s.charAt(left) == s.charAt(right)) {

            left--;
            right++;
        }

        return right - left - 1;
    }

    public String longestPalindrome(String s) {

        int start = 0;
        int maxLength = 1;

        for (int i = 0; i < s.length(); i++) {

            int oddLength = expandAroundCenter(s, i, i);
            int evenLength = expandAroundCenter(s, i, i + 1);

            int currentLength = Math.max(oddLength, evenLength);

            if (currentLength > maxLength) {

                maxLength = currentLength;

                start = i - (currentLength - 1) / 2;
            }
        }

        return s.substring(start, start + maxLength);
    }
}