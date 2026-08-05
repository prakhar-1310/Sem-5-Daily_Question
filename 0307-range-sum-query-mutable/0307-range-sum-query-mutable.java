class NumArray {

    Fenwick fen;
    int arr[];

    public NumArray(int[] nums) {

        fen = new Fenwick(nums.length);
        arr = nums.clone();

        for(int i=0;i<nums.length;i++){
            fen.update(i, nums[i]);
        }
        
    }
    
    public void update(int index, int val) {
        int delta = val - arr[index];
        arr[index] = val;
        fen.update(index, delta);
    }
    
    public int sumRange(int left, int right) {
        int r = fen.query(right);
        if(left==0)return r;
        int l = fen.query(left-1);
        return r-l;
    }

    class Fenwick{
        int n;
        int tree[];

        public Fenwick(int n){
            this.n=n;
            this.tree= new int[n+1];
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

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */