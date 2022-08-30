class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> returnList= new ArrayList<>();
        if(nums == null || nums.length <3) return returnList;
        Arrays.sort(nums);
        for(int i =0; i< nums.length-2; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int target = - nums[i];
            int left = i +1;
            int right =nums.length -1;
            twoSum(nums, left, right, target, returnList);
        }
        return returnList;
    }
    
    private void twoSum(int[] nums, int left, int right, int target, List<List<Integer>> returnList){
        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum == target){
                generateTriplet(nums, left, right, target, returnList);
                left ++;
                right --;
                while(left < right & nums[left] == nums[left -1]){
                    left++;
                }
                while(left < right && nums[right] == nums[right +1]){
                    right --;
                }
            }else if(sum < target){
                left ++;
            }else{
                right --;
            }
        }
    }
    
    private void generateTriplet(int[] nums, int left, int right, int target, List<List<Integer>> returnList){
        List<Integer> level = new ArrayList<>();
        level.add(-target);
        level.add(nums[left]);
        level.add(nums[right]);
        returnList.add(level);
    }
}

//Time Complexity: O(nlogn)
//Space Complexity: O(n)

