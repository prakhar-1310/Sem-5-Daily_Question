class Solution {
    public int slidingPuzzle(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<2;i++){
            for(int j=0;j<3;j++){
                sb.append(board[i][j]);
            }
        }
        String target= "123450";
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        map.put(0, new ArrayList<>(Arrays.asList(1, 3)));
        map.put(1, new ArrayList<>(Arrays.asList(0, 2, 4)));
        map.put(2, new ArrayList<>(Arrays.asList(1, 5)));
        map.put(3, new ArrayList<>(Arrays.asList(0, 4)));
        map.put(4, new ArrayList<>(Arrays.asList(1, 3, 5)));
        map.put(5, new ArrayList<>(Arrays.asList(2, 4)));

        Queue<Pair>q = new LinkedList<>();
        q.add(new Pair(0, sb.toString()));

        HashSet<String>set=new HashSet<>();

        while(!q.isEmpty()){
            Pair rm = q.poll();

            if(set.contains(rm.state))continue;

            set.add(rm.state);

            if(rm.state.equals(target)){
                return rm.cnt;
            }

            for(int i=0;i<6;i++){
                if(rm.state.charAt(i)=='0'){
                    for(int x : map.get(i)){
                        StringBuilder nextState = new StringBuilder();
                        for(int j=0;j<6;j++){
                            if(j==x){
                                nextState.append('0');
                            }
                            else if(j==i){
                                nextState.append(rm.state.charAt(x));
                            }
                            else{
                                nextState.append(rm.state.charAt(j));
                            }
                        }
                        q.add(new Pair(rm.cnt+1, nextState.toString()));
                    }


                    break;
                }
            }
        }

        return -1;
    }

    class Pair{
        int cnt;
        String state;

        public Pair(int cnt, String state){
            this.cnt = cnt;
            this.state = state;
        }
    }
}