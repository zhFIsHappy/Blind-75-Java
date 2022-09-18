class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (b[1]- a[1]));
        for( int num : nums) map.put(num, map.getOrDefault(num, 0) +1);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.add(new int[] {entry.getKey(), entry.getValue()});
        }
        for(int i =0; i< k; i++) result[i] = pq.poll()[0];
        return result;
    }
}

// Time Complexity: O(NlogK)
// Space Complexity: O(N +K)