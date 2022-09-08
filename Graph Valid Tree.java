class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n == 1) return true;
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge : edges){
            if(!graph.containsKey(edge[0])){
                graph.put(edge[0], new ArrayList<>());
            }
            graph.get(edge[0]).add(edge[1]);
            if(!graph.containsKey(edge[1])){
                graph.put(edge[1], new ArrayList<>());
            }
            graph.get(edge[1]).add(edge[0]);
        }
        
        HashSet<Integer> visited = new HashSet<>();
        visited.add(0);
        boolean res = helper(graph, visited, 0 , -1);
        if(!res){
            return false;
        }
        return visited.size() == n;
    }
    
    private boolean helper(HashMap<Integer, List<Integer>> graph, HashSet<Integer> visited, int curr, int parent){
        if(!graph.containsKey(curr)){
            return false;
        }
        List<Integer> subs = graph.get(curr);
        for(int sub : subs){
            if(parent == sub){
                continue;
            }
            if(visited.contains(sub)){
                return false;
            }
            visited.add(sub);
            boolean res = helper(graph, visited, sub, curr);
            if(!res){
                return false;
            }
        }
        return true;
    }
}
// Time Complexity : O(V+E)
// Space Complexity : O(V+E)