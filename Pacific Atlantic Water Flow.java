// 思路： 从pacific 和 atlanta的边缘低的数往里走， 如果两边走的都到同一个高的数， 把这个数加到list中
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if(heights == null || heights.length == 0) return res;
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for(int i = 0 ;i <m; i++){
            dfs(heights, pacific, Integer.MIN_VALUE, i , 0);
            dfs(heights, atlantic, Integer.MIN_VALUE, i, n-1);
        }
        for(int j =0; j < n; j++){
            dfs(heights, pacific, Integer.MIN_VALUE, 0 , j );
            dfs(heights, atlantic, Integer.MIN_VALUE, m-1, j);
        }
        
        for(int i = 0; i< m; i++){
            for(int j = 0; j < n ; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }
    private void dfs(int[][] heights, boolean[][]visited, int pre, int i, int j){
        if(i < 0 || i>= heights.length || j < 0 || j>= heights[0].length){
            return;
        }
        if(visited[i][j]) return;
        if(heights[i][j] < pre){
            return;
        }
        visited[i][j] = true;
        dfs(heights, visited, heights[i][j], i+1, j);
        dfs(heights, visited, heights[i][j], i-1, j);
        dfs(heights, visited, heights[i][j], i, j+1);
        dfs(heights, visited, heights[i][j], i, j-1);
    }
}
// Time Complexity: O(M*N) where M is number of rows, and N is number of columns
// Space Complexity: O(M*N) DFS use recursion stack also