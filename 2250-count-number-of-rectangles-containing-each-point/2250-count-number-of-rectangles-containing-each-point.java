class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        int[] count = new int[points.length];
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        // Group rectangles by height
        for (int[] rect : rectangles) {
            map.putIfAbsent(rect[1], new ArrayList<>());
            map.get(rect[1]).add(rect[0]);
        }

        // Sort widths for each height
        for (List<Integer> list : map.values()) {
            Collections.sort(list);
        }

        // Process each point
        for (int i = 0; i < points.length; i++) {
            int cur = 0;

            for (int h = points[i][1]; h <= 100; h++) {
                if (map.containsKey(h)) {
                    List<Integer> list = map.get(h);

                    int lo = 0, hi = list.size() - 1;
                    int idx = list.size();

                    // Binary search: first width >= x
                    while (lo <= hi) {
                        int mid = (lo + hi) / 2;
                        if (list.get(mid) >= points[i][0]) {
                            idx = mid;
                            hi = mid - 1;
                        } else {
                            lo = mid + 1;
                        }
                    }

                    cur += list.size() - idx;
                }
            }

            count[i] = cur;
        }

        return count;
    }
}

        