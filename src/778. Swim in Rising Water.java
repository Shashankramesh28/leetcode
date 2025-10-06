class Solution {
    private int n;
    private int[][] adjacentDirections = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    public int swimInWater(int[][] grid) {
        int time = Integer.MAX_VALUE;
        n = grid.length;
        int low = 0, high = n*n - 1;
        
        while (low <= high) {
            int mid = (low+high)/2;
            boolean[][] visited = new boolean[n][n];
            if(grid[0][0] <= mid && timeTaken(0, 0, mid, grid, visited)){
                time = mid;
                high = mid -1;
            }
            else{
                low = mid+1;
            }
        }
        return time;
    }

    private boolean timeTaken(int i, int j, int mid,  int[][] grid, boolean[][] visited){
        visited[i][j] = true;
        if(i == n - 1 && j == n - 1) return true;

        for(int[] d : adjacentDirections){
            int x = i+d[0], y = j+d[1];
            if(x>=0 && x < n && y>=0 && y<n && !visited[x][y] && grid[x][y] <= mid ){
                if(timeTaken(x, y, mid, grid, visited)) return true;
            }
        }
        return false;
    }
}