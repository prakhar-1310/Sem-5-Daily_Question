class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Queue<Integer> q = new LinkedList<>();
        int indeg[] = indegree(prerequisites, numCourses);
        int ans[]=new int[numCourses];
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;

        while (!q.isEmpty()) {
            int r = q.poll();
            ans[count]=r;
            count++;

            for (int i[] : prerequisites) {
                if (i[1] == r) { // only for courses dependent on 'r'
                    indeg[i[0]]--;
                    if (indeg[i[0]] == 0) {
                        q.add(i[0]);
                    }
                }
            }
        }

        if(count == numCourses){
            return ans;
        }
        return new int[0];
    }

    public int[] indegree(int pre[][], int n) {
        int in[] = new int[n];
        for (int i[] : pre) {
            in[i[0]]++;
        }
        return in;
    }
}