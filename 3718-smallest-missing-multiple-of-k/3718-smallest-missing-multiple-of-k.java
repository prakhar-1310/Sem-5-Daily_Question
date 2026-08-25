class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer>set = new HashSet<>();
        for(int i : nums){
            if(i%k==0) set.add(i);
        }

        int i=2;
        int tem = k;
        while(true){
            if(set.contains(k)){
                k=tem*i;
                i++;
            }
            else{
                return k;
            }
        }
    }
}