class Solution {
    public int minOperations(int n, int m) {
        if (isPrime(n) || isPrime(m)) return -1;

        PriorityQueue<Pair>pq= new PriorityQueue<>((a,b)->{
            return a.cost-b.cost;
        });

        HashSet<Integer>visited = new HashSet<>();
        pq.add(new Pair(n,n));

        while(!pq.isEmpty()){
            Pair rm = pq.poll();

            if(visited.contains(rm.vtx)){
                continue;
            }

            visited.add(rm.vtx);

            if(rm.vtx == m){
                return rm.cost;
            }

            String str = rm.vtx+"";
            int len = str.length();
            for(int i=0;i<len;i++){
                char ch=str.charAt(i);
                if(ch!='0'){
                    String fin = str.substring(0,i)+(char)(ch-1)+str.substring(i+1,str.length());
                    int ngbr = Integer.parseInt(fin);
                    if(!visited.contains(ngbr) && !isPrime(ngbr)){
                        pq.add(new Pair(ngbr, rm.cost+ngbr));
                    }
                }

                if(ch!='9'){
                    String fin = str.substring(0,i)+(char)(ch+1)+str.substring(i+1,str.length());
                    int ngbr = Integer.parseInt(fin);
                    if(!visited.contains(ngbr) && !isPrime(ngbr)){
                        pq.add(new Pair(ngbr, rm.cost+ngbr));
                    }
                }
            }
        }

        return -1;

    }

    class Pair{
        int vtx;
        int cost;

        public Pair(int vtx, int cost){
            this.vtx=vtx;
            this.cost=cost;
        }
    }

    public boolean isPrime(int n){
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}