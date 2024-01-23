class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) return nums[0];

        int low = 0;
        int high = nums.length-1;

        while (low < high) {
            int mid = (high + low) / 2;

            if (nums[mid] == nums[mid+1]) {
                mid--;
            }

            if ((mid - low) % 2 == 0) {
                high = mid;
            } else {
                low = mid+1;
            }
        }
        return nums[low];
    }
}