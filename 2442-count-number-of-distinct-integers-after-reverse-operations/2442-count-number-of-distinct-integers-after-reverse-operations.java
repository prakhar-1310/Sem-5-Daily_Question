class Solution {
    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer>set=new HashSet<>();
        for(int i : nums){
            set.add(i);
            int n=0;
            int flag=0;
            while(i>0){
                int rem = i%10;
                i/=10;
                if(flag==0 && rem==0){
                    continue;
                }
                else{
                    flag=1;
                    n*=10;
                    n+=rem;
                }
            }
            set.add(n);
        }

        return set.size();
    }
}