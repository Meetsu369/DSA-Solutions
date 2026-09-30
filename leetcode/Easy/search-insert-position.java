// Problem: Search Insert Position
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/search-insert-position/
// Solved on: 2026-09-30T17:37:12.580Z

class Solution {
    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}