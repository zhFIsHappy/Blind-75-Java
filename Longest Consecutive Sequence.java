class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        int longest = 0;
        for(int j : nums){
            set.add(j);
        }
        for(int i : nums){
            if(!set.contains(i-1)){
                int length = 0;
                while(set.contains(i+length)){
                    length +=1;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}

// Time Complexity :O(N)
// Space Complexity: O(N)

// ？？