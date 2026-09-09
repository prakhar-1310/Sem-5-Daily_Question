class Solution {
    public int minFlips(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        List<List<Integer>> tar = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                row.add(0);
            }
            tar.add(row);
        }

        List<List<Integer>> start = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                row.add(mat[i][j]);
            }
            start.add(row);
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, 0));

        HashSet<List<List<Integer>>> set = new HashSet<>();

        while (!q.isEmpty()) {
            Pair rm = q.poll();

            if (set.contains(rm.state))
                continue;

            set.add(rm.state);

            if (rm.state.equals(tar)) {
                return rm.cnt;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {

                    // IMPORTANT: copy before modifying
                    List<List<Integer>> next = new ArrayList<>();

                    for (List<Integer> row : rm.state) {
                        next.add(new ArrayList<>(row));
                    }

                    // current
                    next.get(i).set(j,
                        1 - next.get(i).get(j));

                    // up
                    if (i - 1 >= 0) {
                        next.get(i - 1).set(j,
                            1 - next.get(i - 1).get(j));
                    }

                    // down
                    if (i + 1 < n) {
                        next.get(i + 1).set(j,
                            1 - next.get(i + 1).get(j));
                    }

                    // left
                    if (j - 1 >= 0) {
                        next.get(i).set(j - 1,
                            1 - next.get(i).get(j - 1));
                    }

                    // right
                    if (j + 1 < m) {
                        next.get(i).set(j + 1,
                            1 - next.get(i).get(j + 1));
                    }

                    q.add(new Pair(next, rm.cnt + 1));
                }
            }
        }

        return -1;
    }

    class Pair {
        List<List<Integer>> state;
        int cnt;

        public Pair(List<List<Integer>> state, int cnt) {
            this.state = state;
            this.cnt = cnt;
        }
    }
}