class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals == null || intervals.length <= 1) return true;
        Arrays.sort(intervals, (a,b) -> (a[0] - b[0]));
        int[] curr = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] >= curr[1]){
                curr = intervals[i];
            }else{
                return false;
            }
        }
        return true;
    }
}
// Time Complexity : O(nlogn)
// Space Complexity : O(N)

// Optimal Solution

class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0]-b[0]));
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }
}

// Time Complexity: O(nlogn)
// Space Complexity: O(1)