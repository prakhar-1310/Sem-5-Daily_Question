class Solution {
    static List<String>list ;
    public List<String> findWords(char[][] matrix, String[] words) {
        list = new ArrayList<>();
        Node nn = new Node();
		nn.data = '*';
		root = nn;

		for(String s : words) {
			insert(s);
		}
		
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				if(root.child.containsKey(matrix[i][j])) {
					search(matrix,i,j,root);
				}
			}
		}
		
		return list;
    }

    class Node{
		char data;
		HashMap<Character, Node> child = new HashMap<>();
		String isTerminal;
	}
		
	private static Node root;
		
	public void insert(String word) {
		Node temp = root;
		for(int i=0;i<word.length();i++) {
			char ch = word.charAt(i);
			if(temp.child.containsKey(ch)) {
				temp = temp.child.get(ch);
			}
			else {
				Node nn = new Node();
				nn.data = ch;
				temp.child.put(ch, nn);
				temp=nn;
			}
		}
		temp.isTerminal=word;
	}
	
	public void search(char [][]matrix, int i, int j, Node node) {
		if(i<0 || j<0 || i>=matrix.length || j>=matrix[0].length ||  !node.child.containsKey(matrix[i][j])) {
			return;
		}
		
		char ch = matrix[i][j];
		node = node.child.get(ch);
		if(node.isTerminal!=null) {
			list.add(node.isTerminal);
			node.isTerminal=null;
		}
		matrix[i][j] = '*';
		
		search(matrix,i+1,j,node);
		search(matrix,i,j+1,node);
		search(matrix,i-1,j,node);
		search(matrix,i,j-1,node);
		
		matrix[i][j] = ch;
	}
}