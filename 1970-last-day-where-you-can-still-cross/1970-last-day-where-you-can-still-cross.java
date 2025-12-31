class Solution {
    private int[] parent, rank;
    private int rows, cols;
    private int top, bottom;

    public int latestDayToCross(int row, int col, int[][] cells) {
        rows = row;
        cols = col;

        int n = row * col;
        parent = new int[n + 2];
        rank = new int[n + 2];

        top = n;
        bottom = n + 1;

        for (int i = 0; i < n + 2; i++) parent[i] = i;

        boolean[][] land = new boolean[row][col];

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        for (int d = cells.length - 1; d >= 0; d--) {
            int r = cells[d][0] - 1;
            int c = cells[d][1] - 1;

            land[r][c] = true;
            int id = r * cols + c;

            for (int[] di : dir) {
                int nr = r + di[0], nc = c + di[1];
                if (nr >= 0 && nc >= 0 && nr < rows && nc < cols && land[nr][nc]) {
                    union(id, nr * cols + nc);
                }
            }

            if (r == 0) union(id, top);
            if (r == rows - 1) union(id, bottom);

            if (find(top) == find(bottom)) return d;
        }

        return 0;
    }

    private int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    private void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;
        if (rank[a] < rank[b]) parent[a] = b;
        else if (rank[a] > rank[b]) parent[b] = a;
        else {
            parent[b] = a;
            rank[a]++;
        }
    }
}