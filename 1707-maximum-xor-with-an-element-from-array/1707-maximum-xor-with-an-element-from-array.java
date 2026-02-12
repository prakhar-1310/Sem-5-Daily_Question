class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int q[][] = new int[queries.length][3];
		for(int i=0;i<q.length;i++) {
			q[i][0]=queries[i][0]; // xi
			q[i][1]=queries[i][1]; // mi
			q[i][2]=i;
		}
		
		Arrays.sort(nums);
		Arrays.sort(q, (a,b)->{
			return a[1]-b[1];
		});
		
		int ans[] = new int[q.length];
		Trie T = new Trie();
		
		int j=0;
		
		for(int i[] : q) {
			int xi = i[0];
			int mi = i[1];
			int idx = i[2];
			
			while(j<nums.length && nums[j]<=mi) {
				T.add(nums[j]);
				j++;
			}
			if(j==0) {
				ans[idx]=-1;
			}
			else {
				int getmax = T.getMaxXor(xi);
				ans[idx]=getmax;
			}
		}

        return ans;
    }

    static class Trie{
		class Node{
			Node one;
			Node zero;
		}
		
		private Node root = new Node();
		
		public void add(int val) {
			Node curr=root;
			for(int i=31;i>=0;i--) {
				int mask = (1<<i);
				int bit = val & mask;
				if(bit!=0) {
					if(curr.one!=null) {
						curr=curr.one;
					}
					else {
						Node nn = new Node();
						curr.one=nn;
						curr=nn;
					}
				}
				else{
					if(curr.zero!=null) {
						curr=curr.zero;
					}
					else {
						Node nn = new Node();
						curr.zero=nn;
						curr=nn;
					}
				}
			}
		}
		
		public int getMaxXor(int x) {
			Node curr = root;
			int ans=0;
			for(int i=31;i>=0;i--) {
				int mask = (1<<i);
				int bit = x & mask;
				if(bit==0) {
					if(curr.one!=null) {
						ans = ans|(1<<i);
						curr = curr.one;
					}
					else {
						curr=curr.zero;
					}
				}
				else {
					if(curr.zero!=null) {
						ans = ans|(1<<i);
						curr = curr.zero;
					}
					else {
						curr = curr.one;
					}	
				}	
			}
			return ans;
		}
	}
}