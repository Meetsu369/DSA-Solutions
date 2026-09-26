// Problem: Substring with Concatenation of All Words
// Platform: leetcode
// Rating/Difficulty: Unrated
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/substring-with-concatenation-of-all-words/
// Solved on: 2026-09-26T12:51:24.675Z

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        if (s.length() < totalLen) {
            return result;
        }

        Map<String, Integer> required = new HashMap<>();

        for (String word : words) {
            required.put(word,
                    required.getOrDefault(word, 0) + 1);
        }

        for (int offset = 0; offset < wordLen; offset++) {

            int left = offset;
            int right = offset;
            int count = 0;

            Map<String, Integer> window = new HashMap<>();

            while (right + wordLen <= s.length()) {

                String word = s.substring(right, right + wordLen);
                right += wordLen;

                if (!required.containsKey(word)) {
                    window.clear();
                    count = 0;
                    left = right;
                    continue;
                }

                window.put(word,
                        window.getOrDefault(word, 0) + 1);

                count++;

                while (window.get(word) > required.get(word)) {

                    String leftWord =
                            s.substring(left, left + wordLen);

                    window.put(leftWord,
                            window.get(leftWord) - 1);

                    left += wordLen;
                    count--;
                }

                if (count == wordCount) {
                    result.add(left);
                }
            }
        }

        return result;
    }
}