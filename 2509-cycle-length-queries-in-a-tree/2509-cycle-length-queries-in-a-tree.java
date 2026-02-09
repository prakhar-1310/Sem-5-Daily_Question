import java.util.*;

class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int m = queries.length;
        int[] result = new int[m];
        
        for (int i = 0; i < m; i++) {
            int a = queries[i][0], b = queries[i][1];
            int t = 1; // extra edge
            while (a != b) {
                if (a > b) {
                    a /= 2;
                } else {
                    b /= 2;
                }
                t++;
            }
            result[i] = t;
        }
        return result;
    }
}