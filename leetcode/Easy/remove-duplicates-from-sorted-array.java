// Problem: Remove Duplicates from Sorted Array
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
// Solved on: 2026-09-21T14:51:48.470Z

class Solution {
    public int removeDuplicates(int[] nums) {

        int write = 1;

        for (int read = 1; read < nums.length; read++) {

            if (nums[read] != nums[write - 1]) {

                nums[write] = nums[read];

                write++;
            }
        }

        return write;
    }
}