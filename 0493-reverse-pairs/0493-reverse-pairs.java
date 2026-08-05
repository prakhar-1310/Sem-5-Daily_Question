class Solution {
    public int reversePairs(int[] nums) {
        long tem[] = new long[2*nums.length];
        int i=0;
        int j=0;
        while(i<nums.length){
            tem[j++]=nums[i];
            tem[j++]=2L*nums[i++];
        }

        Arrays.sort(tem);
        HashMap<Long, Integer>map =new HashMap<>();
        int rank=1;

        for(long k : tem){
            if(!map.containsKey(k)){
                map.put(k, rank++);
            }
        }

        Fenwick fen = new Fenwick(rank);
        int ans=0;
        for(int k=nums.length-1;k>=0;k--){
            int idx = map.get(1L*nums[k]);

            ans+=fen.query(idx-1);

            fen.update(map.get(2L*nums[k]),1);
        }

        return ans;
    }

    class Fenwick{
        int n;
        int tree[];

        public Fenwick(int n){
            this.n=n;
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