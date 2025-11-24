class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean>list = new ArrayList<>();
        int sum=0;
        for(int i : nums){
            sum=((sum*2)+i)%5;
            if(sum%5==0){
                list.add(true);
            }
            else{
                list.add(false);
            }
            
        }

        return list;
    }
}