class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        for(int i=1;i<=edges.length;i++){
            createSet(i);
        }
        for(int e[] : edges){
            int e1 = e[0];
            int e2 = e[1];

            Node rn1 = find(map.get(e1));
            Node rn2 = find(map.get(e2));

            if(rn1==rn2){
                return e;
            }
            else{
                union(e1,e2);
            }
        }

        return new int[0];
    }
    class Node{
        int rank;
        Node parent;
        int val; 
    }

    public void createSet(int v){
        Node n = new Node();
        n.rank=0;
        n.parent = n;
        n.val = v;
        map.put(v,n);
    }

    private HashMap<Integer,Node>map = new HashMap<>();

    public Node find(Node n){
        if(n.parent==n){
            return n;
        }

        Node rn = find(n.parent);
        n.parent = rn;
        return rn;
    }

    public void union(int e1, int e2){
        Node n1 = map.get(e1);
        Node n2 = map.get(e2);

        Node rn1 = find(n1);
        Node rn2 = find(n2);

        if(rn1.rank == rn2.rank){
            rn1.parent = rn2;
            rn2.rank++;
        }

        else if(rn1.rank > rn2.rank){
            rn2.parent = rn1;
        }

        else{
            rn1.parent = rn2;
        }
    }
}