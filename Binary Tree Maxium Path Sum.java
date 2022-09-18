class Solution {
    int maxValue = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        max_gain(root);
        return maxValue;
    }
    
    public int max_gain(TreeNode root){
        if(root == null) return 0;
        int left = Math.max(max_gain(root.left), 0 );
        int right = Math.max(max_gain(root.right), 0 );
        int curValue = left +right + root.val;
        maxValue = Math.max(maxValue, curValue);
        return root.val + Math.max(left, right);
    }
}

// Time Complexity : O(N)
// Space Complexity: O(logN)