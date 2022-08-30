class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int currSum = nums[0];
        int maxSum = currSum;
        for(int i =1; i < nums.length; i++){
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)