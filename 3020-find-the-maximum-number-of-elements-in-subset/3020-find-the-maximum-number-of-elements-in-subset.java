class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Long,Integer>map = new HashMap<>();
        for (int num : nums) {
            map.put((long) num, map.getOrDefault((long) num, 0) + 1);
        }

        Arrays.sort(nums);

        int len = Integer.MIN_VALUE;
        HashSet<Long>set=new HashSet<>();
        for(long i : nums){
            if(i<=1)continue;
            
            if(set.contains(i)) continue;
            int cnt=0;
            while(map.containsKey(i) && map.get(i) >= 2){
                set.add(i);
                cnt+=2;
                i=i*i;
            }

            if(map.containsKey(i)){
                cnt++;
            }
            else{
                cnt--;
            }
            
            len = Math.max(len, cnt);
        }

        if(map.containsKey(1L)){
            len = Math.max(len, map.get(1L));
        }

        return len%2==0 ? len-1 : len;
    }
}