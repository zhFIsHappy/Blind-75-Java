class Solution {
    public int maxArea(int[] height) {
        if(height == null || height.length == 0) return 0;
        int start = 0;
        int maxArea = 0;
        int end = height.length -1;
        while(start < end){
            if(height[start]< height[end]){
                maxArea = Math.max(maxArea, height[start] *(end -start));
                start++;
            }else{
                maxArea = Math.max(maxArea, height[end] *(end -start));
                end--;
            }
        }
        return maxArea;
    }
}
// Time Complexity : O(N)
// Space Complexity: O(1)