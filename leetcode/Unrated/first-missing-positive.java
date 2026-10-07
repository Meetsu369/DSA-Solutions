// Problem: First Missing Positive
// Platform: leetcode
// Rating/Difficulty: Unrated
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/first-missing-positive/
// Solved on: 2026-10-07T19:40:33.422Z

class Solution {
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            while (nums[i] >= 1 &&
                   nums[i] <= n &&
                   nums[nums[i] - 1] != nums[i]) {

                int correctIndex = nums[i] - 1;

                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
        }

        for (int i = 0; i < n; i++) {

            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
}