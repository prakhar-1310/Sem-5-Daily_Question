class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int tem[] = nums.clone();
        Arrays.sort(tem);

        HashMap<Integer, Integer>map = new HashMap<>();
        int rank=1;
        for(int i : tem){
            if(!map.containsKey(i)){
                map.put(i, rank++);
            }
        }
        Fenwick fen = new Fenwick(rank);
        List<Integer>ans = new ArrayList<>();
        for(int i=nums.length-1;i>=0;i--){
            int idx = map.get(nums[i]);

            ans.add(fen.query(idx-1));
            fen.update(idx, 1);
        }

        Collections.reverse(ans);

        return ans;
    }

    class Fenwick{
        int n;
        int tree[];

        public Fenwick(int n){
            this.n = n;
            this.tree = new int[n+1];
        }

        public void update(int idx, int delta){
            idx++;
            while(idx<=n){
                tree[idx]+=delta;
                idx+=(idx&(-idx));
            }
        }

        public int query(int idx){
            idx++;
            int sum=0;
            while(idx>0){
                sum+=tree[idx];
                idx-=(idx&(-idx));
            }

            return sum;
        }
    }
}