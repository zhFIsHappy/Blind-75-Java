class Solution {
    public int maxProfit(int[] nums) {
        if(nums == null || nums.length==0) return 0;
        int minLoss = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for(int i =0; i< nums.length ; i++){
            minLoss = Math.min(minLoss, nums[i]);
            maxProfit = Math.max(maxProfit, nums[i] - minLoss);
        }
        return maxProfit;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)