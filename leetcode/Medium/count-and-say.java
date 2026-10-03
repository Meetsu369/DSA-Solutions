// Problem: Count and Say
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/count-and-say/
// Solved on: 2026-10-03T18:13:07.431Z

class Solution {
    public String countAndSay(int n) {

        String current = "1";

        for (int step = 2; step <= n; step++) {

            StringBuilder next = new StringBuilder();

            int i = 0;

            while (i < current.length()) {

                char digit = current.charAt(i);
                int count = 0;

                // Count consecutive identical digits
                while (i < current.length()
                        && current.charAt(i) == digit) {
                    count++;
                    i++;
                }

                // Append count + digit
                next.append(count);
                next.append(digit);
            }

            current = next.toString();
        }

        return current;
    }
}