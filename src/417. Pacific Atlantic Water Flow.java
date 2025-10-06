import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    int m,n;
    int[][] adjacentDirections = new int[][] {{1, 0}, {0,-1}, {-1, 0}, {0, 1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for(int i=0;i<m;i++) dfsTraversal(i, 0, heights, pacific);
        for(int i=0;i<n;i++) dfsTraversal(0, i, heights, pacific);
        for(int i=0;i<m;i++) dfsTraversal(i, n-1, heights, atlantic);
        for(int i=0;i<n;i++) dfsTraversal(m-1, i, heights, atlantic);

        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }

    public void dfsTraversal(int i, int j, int [][] heights, boolean[][] visited){
        if(visited[i][j]) return;
        visited[i][j] = true;
        for(int[] d: adjacentDirections){
            int x = i+d[0], y = j+d[1];
            if(x < 0 || x>=m || y<0 || y>=n) continue;
            if(heights[x][y] < heights[i][j]) continue;
            dfsTraversal(x, y, heights, visited);
        }
    }
}