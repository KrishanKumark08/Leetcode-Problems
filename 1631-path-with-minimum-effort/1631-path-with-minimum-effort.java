class Solution {
    private boolean dfs(int[][] h, int i, int j, int prev, int limit, boolean[][] visited) {
        if(i < 0 || i >= h.length || j < 0 || j >= h[0].length || visited[i][j] || Math.abs(h[i][j] - prev) > limit) return false;
        visited[i][j] = true;
        return (i == h.length - 1 && j == h[0].length - 1) || dfs(h, i - 1, j, h[i][j], limit, visited) || dfs(h, i + 1, j, h[i][j], limit, visited) || dfs(h, i, j - 1, h[i][j], limit, visited) || dfs(h, i, j + 1, h[i][j], limit, visited);
    }
    public int minimumEffortPath(int[][] heights) {
        int l = 0, r = 1_000_000;
        while(l < r) {
            int m = l + ((r - l) >> 1);
            if(dfs(heights, 0, 0, heights[0][0], m, new boolean[heights.length][heights[0].length])) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}