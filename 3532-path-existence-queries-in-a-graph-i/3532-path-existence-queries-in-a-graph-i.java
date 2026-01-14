class Solution {
    class Node {
		int val;
		int rank;
		Node parent;
	}

	HashMap<Integer, Node> map = new HashMap<>();

	public void create(int v) {
		Node nn = new Node();
		nn.val = v;
		nn.rank = 0;
		nn.parent = nn;
		map.put(v, nn);

	}

	public int find(int v) {
		Node node = map.get(v);
		return find(node).val;

	}

	private Node find(Node node) {
		if (node.parent == node) {
			return node;
		}
		Node n = find(node.parent);
		node.parent = n;// path Compression
		return n;

	}

	public void union(int v1, int v2) {
		Node node1 = map.get(v1);
		Node node2 = map.get(v2);
		Node re1 = find(node1);
		Node re2 = find(node2);
		if (re1.rank == re2.rank) {
			re1.parent = re2;
			re2.rank++;
		} else if (re1.rank < re2.rank) {
			re1.parent = re2;
		} else {
			re2.parent = re1;
		}
	}
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        // Create DSU nodes
        for(int i=0 ;i<n ;i++){
            create(i);
        }
         // Union adjacent nodes if difference <= maxDiff
        for(int i=1 ;i<nums.length ;i++){
            if(nums[i] - nums[i-1] <= maxDiff){
                union(i, i-1);
            }
        }
        boolean[] ans = new boolean[queries.length];
        int idx =0;
        // Answer queries
        for(int i=0 ;i<queries.length ;i++){
            int start = queries[i][0];
            int end = queries[i][1];

            if(find(start) == find(end)){
                ans[idx++] = true;
            }else{
                ans[idx++] = false;
            }
        }

        return ans;
    }
}