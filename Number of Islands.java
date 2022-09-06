class Coordinate{
    int x, y;
    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public static int[] dx = {0,1,-1,0};
    public static int[] dy = {1,0,0,-1};
    public int numIslands(char[][] grid) {

        if(grid == null || grid.length  == 0 || grid[0] == null || grid[0].length == 0){
            return 0;
        }
        int islands = 0;
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        
        for(int i = 0; i < row; i++){
            for(int j =0; j < col; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    bfs(grid, i , j , visited);
                    islands++;
                }
            }
        }
        return islands;
    }
    
    private void bfs(char[][] grid, int i, int j, boolean[][] visited){
        Queue<Coordinate> queue = new ArrayDeque<>();
        queue.offer(new Coordinate(i , j));
        visited[i][j] = true;
        while(!queue.isEmpty()){
            Coordinate curr = queue.poll();
            for(int p =0; p< 4; p ++){
                int newX = curr.x + dx[p];
                int newY = curr.y + dy[p];
                if(!isValid(grid, newX, newY, visited)){
                    continue;
                }
                queue.offer(new Coordinate(newX, newY));
                visited[newX][newY] = true;
            }
        }
    }
    private boolean isValid(char[][] grid, int x, int y , boolean[][] visited){
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length){
            return false;
        }
        if(visited[x][y]){
            return false;
        }
        if(grid[x][y] == '0'){
            return false;
        }
        return true;
    }
}

// Time Complexity: O(M*N)
// Space Complexity: O(min(M,N))