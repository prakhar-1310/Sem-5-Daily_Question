class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        HashSet<Integer>set = new HashSet<>();
        for (int i : nums){
            set.add(i);
        }

        int ans=0;
        for(int i : set){
            int count =1;
            if(!set.contains(i-1)){
                int p = i;
                while(set.contains(p+1)){
                    p++;
                    count++;
                }
                ans = Math.max(ans,count); 
            }
        }
        
        return ans;


        // HashSet<Integer> set = new HashSet<>();
        // for(int i:nums){
        //     set.add(i);
        // }
        // int ans =0;
        // for (int i : nums){
        //     if(!set.contains(i-1)){
        //         int c=0;
        //         int key = i;
        //         while(set.contains(key)){
        //             set.remove(key);
        //             c++;
        //             key++;
        //         }
        //         ans = Math.max(ans,c);
        //     }
        // }

        // return ans;
    }
}