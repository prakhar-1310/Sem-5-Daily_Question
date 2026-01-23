class Solution {
    class Pair {
        int limit, value;
        Pair(int x, int y) {
            this.limit = x;
            this.value = y;
        }
    }
    public long maxTotal(int[] value, int[] limit) {
        ArrayList<Pair> arr = new ArrayList<>();
        int n = value.length, activeCt = 0;
        long totalValue = 0;
        for (int i = 0; i < n; i++) {
            arr.add(new Pair(limit[i], value[i]));
        }
        Collections.sort(arr, (Pair a, Pair b) -> {
            if (a.limit == b.limit) return Integer.compare(b.value, a.value);
            return Integer.compare(a.limit, b.limit);
        });
        for (int i = 0; i < n; ) {
            int currLimit = arr.get(i).limit, currVal = arr.get(i).value;
            int ct = 1;
            totalValue += currVal;
            i++;
            while(i < n && arr.get(i).limit == currLimit && ct < currLimit) {
                totalValue += arr.get(i).value;
                ct++;
                i++;
            }
            while(i < n && arr.get(i).limit == currLimit)   i++;
        }
        return totalValue;
    }
}