class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<>();
        }
        int[] indegree = new int[numCourses];
        for(int[] e : prerequisites){
            graph[e[0]].add(e[1]);
            indegree[e[1]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i< numCourses; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()){
            int curr = queue.poll();
            for(int c : graph[curr]){
                indegree[c] --;
                if(indegree[c] == 0){
                    queue.add(c);
                }
            }
            numCourses --;
        }
        return numCourses == 0;
    }
}
// Time Complexity : O(V+E)
// Space Complexity: O(V+E)