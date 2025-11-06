class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Integer>q = new LinkedList<>();
        int indeg[] = indegree( prerequisites, numCourses);
        for(int i=0;i<indeg.length;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }

        int count=0;

        while(!q.isEmpty()){
            int r = q.poll();

            count++;

            for(int i[] :prerequisites){
                if(i[1]==r){
                    indeg[i[0]]--;
                    if(indeg[i[0]]==0){
                        q.add(i[0]);
                    }
                }
            }
        }

        return count==numCourses;
    }

    public int[] indegree(int pre[][],int n){
        int in[] = new int[n];
        for(int i[] : pre){
            in[i[0]]++;
        }

        return in;
    }
}