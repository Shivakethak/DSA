import java.util.*;

class Pair {
    int row;
    int col;
    int dist;

    Pair(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

class Solution {
    public int shortestPath(int[][] mat, int[] src, int[] dest) {

        int n = mat.length;
        int m = mat[0].length;

        // Source or destination is blocked
        if (mat[src[0]][src[1]] == 0 ||
            mat[dest[0]][dest[1]] == 0) {
            return -1;
        }

        Queue<Pair> q = new LinkedList<>();

        boolean[][] vis = new boolean[n][m];

        q.add(new Pair(src[0], src[1], 0));
        vis[src[0]][src[1]] = true;

        // Up, Right, Down, Left
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!q.isEmpty()) {

            Pair current = q.poll();

            int row = current.row;
            int col = current.col;
            int dist = current.dist;

            // Destination reached
            if (row == dest[0] && col == dest[1]) {
                return dist;
            }

            // Explore 4 directions
            for (int i = 0; i < 4; i++) {

                int nr = row + dr[i];
                int nc = col + dc[i];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < m &&
                    mat[nr][nc] == 1 &&
                    !vis[nr][nc]) {

                    vis[nr][nc] = true;

                    q.add(new Pair(nr, nc, dist + 1));
                }
            }
        }

        return -1;
    }
}