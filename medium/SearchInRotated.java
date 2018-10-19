/**
 * SearchInRotated
 */
public class SearchInRotated {

    public boolean search(int[] nums, int target) {
        int divide = -1;
        int minLeft = nums[0], maxLeft;
        int minRight, maxRight = nums[nums.length - 1];

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                divide = i;
                break;
            }
        }

        if (divide != -1) {
            maxLeft = nums[divide];
            minRight = nums[divide + 1];
            if (target < minRight || target > maxLeft) {
                return false;
            } else if (target > maxRight) {
                return biSearch(nums, 0, divide + 1, target);
            } else {
                return biSearch(nums, divide + 1, nums.length, target);
            }
        } else {
            return biSearch(nums, 0, nums.length, target);
        }
    }

    boolean biSearch(int[] nums, int left, int right, int target) {
        int mid;
        while (left < right) {
            mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return false;
    }

}