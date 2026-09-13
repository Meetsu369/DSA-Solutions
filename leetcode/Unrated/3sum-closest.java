// Problem: 3Sum Closest
// Platform: leetcode
// Rating/Difficulty: Unrated
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/3sum-closest/
// Solved on: 2026-09-13T06:19:36.359Z

class Solution {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int closest = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                // Update closest answer
                if (Math.abs(sum - target) <
                    Math.abs(closest - target)) {

                    closest = sum;
                }

                // Exact answer
                if (sum == target) {
                    return sum;
                }

                // Need a larger sum
                if (sum < target) {
                    left++;
                }

                // Need a smaller sum
                else {
                    right--;
                }
            }
        }

        return closest;
    }
}