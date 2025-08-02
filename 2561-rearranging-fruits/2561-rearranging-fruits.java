import java.util.*;

class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        TreeMap<Integer, Integer> freq = new TreeMap<>(); // Sorted map to track total frequencies
        int minElement = Integer.MAX_VALUE;

        // Count frequency and update minimum element
        for (int i : basket1) {
            map1.put(i, map1.getOrDefault(i, 0) + 1);
            freq.put(i, freq.getOrDefault(i, 0) + 1);
            minElement = Math.min(minElement, i);
        }

        for (int i : basket2) {
            map2.put(i, map2.getOrDefault(i, 0) + 1);
            freq.put(i, freq.getOrDefault(i, 0) + 1);
            minElement = Math.min(minElement, i);
        }

        // If total frequency of any element is odd, return -1 (impossible to match)
        for (int val : freq.values()) {
            if (val % 2 != 0) return -1;
        }

        List<Integer> excess = new ArrayList<>();

        // Find excess elements in basket1
        for (int key : freq.keySet()) {
            int c1 = map1.getOrDefault(key, 0);
            int c2 = map2.getOrDefault(key, 0);
            int diff = c1 - c2;
            if (diff > 0) {
                for (int i = 0; i < diff / 2; i++) {
                    excess.add(key);
                }
            }
        }

        // Find excess elements in basket2
        for (int key : freq.keySet()) {
            int c1 = map1.getOrDefault(key, 0);
            int c2 = map2.getOrDefault(key, 0);
            int diff = c2 - c1;
            if (diff > 0) {
                for (int i = 0; i < diff / 2; i++) {
                    excess.add(key);
                }
            }
        }

        // Sort to always swap smallest first (for minimal cost)
        Collections.sort(excess);
        long cost = 0;

        for (int i = 0; i < excess.size() / 2; i++) {
            cost += Math.min(excess.get(i), 2 * minElement);
        }

        return cost;
    }
}
