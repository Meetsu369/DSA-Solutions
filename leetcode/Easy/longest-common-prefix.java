// Problem: Longest Common Prefix
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/longest-common-prefix/
// Solved on: 2026-09-08T18:31:35.919Z

class Solution {
    public String longestCommonPrefix(String[] strs) {

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {

            int j = 0;

            while (j < prefix.length()
                    && j < strs[i].length()
                    && prefix.charAt(j) == strs[i].charAt(j)) {

                j++;
            }

            prefix = prefix.substring(0, j);

            if (prefix.isEmpty()) {
                return "";
            }
        }

        return prefix;
    }
}