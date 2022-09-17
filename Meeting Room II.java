 class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> queue = new PriorityQueue<>(
            intervals.length, (a, b) -> (a[1] - b[1])
        );

        queue.offer(intervals[0]);

        int res = 1;

        for(int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            int[] prevMeeting = queue.poll();
            if(curr[0] >= prevMeeting[1]) {
                prevMeeting[1] = curr[1];
            } else {
                res++;
                queue.offer(curr);
            }
            queue.offer(prevMeeting);
        }

        return res;
    }
}

// Time Complexity : O(N)
// Space Complexity : O(N)