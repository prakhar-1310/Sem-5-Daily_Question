class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        Node nn = new Node();
		nn.data = '*';
		root = nn;

		for(String i : dict) {
			insert(i);
		}
		String arr[] = sentence.split(" ");
		
		StringBuilder sb = new StringBuilder();
		for(String str : arr) {
			String ins = search(str);
			sb.append(ins);
			sb.append(" ");
		}
		return sb.toString().trim();
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
	
	public static String search(String word) {
		Node temp = root;
		for(int i=0;i<word.length();i++) {
			char ch = word.charAt(i);
			if(temp.child.containsKey(ch)) {
				temp = temp.child.get(ch);
				if(temp.isTerminal!=null) {
					return temp.isTerminal;
				}
			}
			else {
				return word;
			}
		}
		
		return word;
	}
}