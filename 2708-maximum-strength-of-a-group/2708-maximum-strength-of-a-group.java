class Solution {
    public long maxStrength(int[] nums) {
        List<Integer>list = new ArrayList<>();
        long ans=1;
        boolean used = false;
        for(int i : nums){
            if(i<0){
                list.add(i);
            }
            else if (i>0){
                ans*=i;
                used = true;
            }
        }

        Collections.sort(list);
        while(list.size()>=2){
            used = true;
            int a = list.get(0);
            int b = list.get(1);
            long mul = (long)a*b;
            ans*=mul;
            list.remove(0);
            list.remove(0);
        }

        if(!used){
            int max=nums[0];
            for(int i : nums){
                max=Math.max(i,max);
            }
            return max;
        }

        return ans;
    }
}