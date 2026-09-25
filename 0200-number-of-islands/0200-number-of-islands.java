class Pair {
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public static void bfs(int row, int col, Queue<Pair> q, boolean[][] visited, char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        q.add(new Pair(row, col));
        visited[row][col] = true;

        while (!q.isEmpty()) {
            Pair node = q.remove();
            int r = node.row;
            int c = node.col;

            int[] dr = { -1, 1, 0, 0 };
            int[] dc = { 0, 0, -1, 1 };

            for (int i = 0; i < 4; i++) {
                int delRow = r + dr[i];
                int delCol = c + dc[i];

                if (delRow >= 0 && delRow < n && delCol >= 0 && delCol < m && grid[delRow][delCol] == '1'
                        && !visited[delRow][delCol]) {
                    q.add(new Pair(delRow, delCol));
                    visited[delRow][delCol] = true;
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    bfs(i, j, q, visited, grid);
                }
            }
        }
        return count;

    }
}