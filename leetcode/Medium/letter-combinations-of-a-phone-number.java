// Problem: Letter Combinations of a Phone Number
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
// Solved on: 2026-09-13T18:19:54.457Z

class Solution {

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits.length() == 0) {
            return result;
        }

        String[] mapping = {
            "", "", "abc", "def",
            "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"
        };

        StringBuilder current = new StringBuilder();

        backtrack(digits, 0, current, result, mapping);

        return result;
    }

    private void backtrack(
        String digits,
        int index,
        StringBuilder current,
        List<String> result,
        String[] mapping
    ) {

        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = mapping[digits.charAt(index) - '0'];

        for (int i = 0; i < letters.length(); i++) {

            char ch = letters.charAt(i);

            current.append(ch);

            backtrack(
                digits,
                index + 1,
                current,
                result,
                mapping
            );

            current.deleteCharAt(current.length() - 1);
        }
    }
}