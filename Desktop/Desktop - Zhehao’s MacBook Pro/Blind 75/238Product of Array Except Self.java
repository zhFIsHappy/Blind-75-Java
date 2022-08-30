class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];
        int[] left = new int[length];
        int[] right = new int[length];
        
        left[0] = 1;
        for(int i =1; i< length; i++){
            left[i] = left[i-1] * nums[i-1];
        }
        right[length -1] = 1;
        for(int i =length-2; i >= 0; i--){
            right[i] = right[i+1] * nums[i+1];
        }
        
        for(int i =0; i< length; i++){
            answer[i] = left[i] * right[i];
        }
        return answer;
    }
}
// Time Complexity O(N)
// Space Complexity O(N)

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];
        
        
        answer[0] = 1;
        for(int i =1; i< length; i++){
            answer[i] = answer[i-1] * nums[i-1];
        }
        int right =1;
        for(int i =length-1; i >= 0; i--){
            answer[i] = answer[i] * right;
            right *= nums[i];
        }
        return answer;
    }
}

// Time Complexity O(N)
// Space Complexity O(1)