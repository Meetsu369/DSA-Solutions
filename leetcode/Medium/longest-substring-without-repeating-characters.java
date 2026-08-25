// Problem: Longest Substring Without Repeating Characters
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/longest-substring-without-repeating-characters/
// Solved on: 2026-08-25T18:19:52.437Z

class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            char current = s.charAt(right);

            if (map.containsKey(current)) {
                left = Math.max(left, map.get(current) + 1);
            }

            map.put(current, right);

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}