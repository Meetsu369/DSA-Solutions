// Problem: Multiply Strings
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/multiply-strings/
// Solved on: 2026-10-09T18:22:41.569Z

class Solution {
    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int m = num1.length();
        int n = num2.length();

        int[] result = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';

                int p = i + j + 1;

                int sum = digit1 * digit2 + result[p];

                result[p] = sum % 10;
                result[p - 1] += sum / 10;
            }
        }

        StringBuilder answer = new StringBuilder();
        int i = 0;

        while (i < result.length && result[i] == 0) {
            i++;
        }

        while (i < result.length) {
            answer.append(result[i]);
            i++;
        }

        return answer.toString();
    }
}