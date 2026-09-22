// Problem: Remove Element
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/remove-element/
// Solved on: 2026-09-22T14:14:31.825Z

class Solution {
    public int removeElement(int[] nums, int val) {

        int write = 0;

        for (int read = 0; read < nums.length; read++) {

            if (nums[read] != val) {
                nums[write] = nums[read];
                write++;
            }
        }

        return write;
    }
}