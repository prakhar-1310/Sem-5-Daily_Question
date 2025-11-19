class Solution {
    public int longestCycle(int[] edges) {
        int []in = new int[edges.length];
		for(int i : edges) {
			if(i!=-1) {
				in[i]++;
			}
		}
		
		Queue<Integer>q= new LinkedList<>();
		
		for(int i=0;i<in.length;i++) {
			if(in[i]==0) {
				q.add(i);
			}
		}
		
		HashSet<Integer>visited = new HashSet<>();
		
		while(!q.isEmpty()) {   // with the help of 
			int edg = q.poll();
			visited.add(edg);
			if(edges[edg]!=-1) {
				in[edges[edg]]--;
				if(in[edges[edg]]==0) {
					q.add(edges[edg]);
				}
			}
		}
		
		int ans =-1;
		for(int i=0;i<edges.length;i++) {  // TC. O(n)
			if(!visited.contains(i)) {
				int c=1;
				visited.add(i);
				int nbrs = edges[i];
				while(nbrs!=i) {
					c++;
					visited.add(nbrs);
					nbrs=edges[nbrs];
				}
				
				ans=Math.max(ans, c);
			}
		}
		
		
		return ans;
    }
}