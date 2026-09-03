// Problem: Integer to Roman
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/integer-to-roman/
// Solved on: 2026-09-03T16:06:28.821Z

class Solution {
    public String intToRoman(int num) {

        int[] values = {
            1000, 900, 500, 400,
            100, 90, 50, 40,
            10, 9, 5, 4, 1
        };

        String[] symbols = {
            "M", "CM", "D", "CD",
            "C", "XC", "L", "XL",
            "X", "IX", "V", "IV", "I"
        };

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < values.length; i++) {

            int count = num / values[i];

            for (int j = 0; j < count; j++) {
                result.append(symbols[i]);
            }

            num = num % values[i];
        }

        return result.toString();
    }
}