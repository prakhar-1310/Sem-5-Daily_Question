class Solution {
    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer>set=new HashSet<>();
        for(int i : nums){
            set.add(i);
            int n=0;
            while(i>0){
                int rem = i%10;
                i/=10;
                n*=10;
                n+=rem;
                
            }
            set.add(n);
        }

        return set.size();
    }
}