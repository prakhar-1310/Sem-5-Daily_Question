class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie t = new Trie();
		for(int i : nums) {
			t.add(i);
		}
		
		int ans = 0;
		
		for(int i : nums) {
			ans =Math.max(ans, t.getMaxXor(i));
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