class Solution {
    public long[] distance(int[] nums) {
        HashMap<Integer,List<Integer>>map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], new ArrayList<>());
            }

            map.get(nums[i]).add(i);
        }

        long arr[] = new long[nums.length];

        for(int i : map.keySet()){
            int n = map.get(i).size();
            long pref[] = new long [n];
            pref[0]=map.get(i).get(0);
            for(int j=1;j<n;j++){
                pref[j]=pref[j-1]+map.get(i).get(j);
            }

            long suff[] = new long [n];
            suff[n-1]=map.get(i).get(n-1);
            for(int j=n-2;j>=0;j--){
                suff[j]=suff[j+1]+map.get(i).get(j);
            }

            for(int j=0;j<n;j++){
                int idx = map.get(i).get(j);
                long left=0;
                if(j>0){
                    left=(long)j*idx - pref[j-1];
                }

                long right=0;
                if(j<n-1){
                    right=suff[j+1]-(long)(n-1-j)*idx;
                }

                arr[idx]=left+right;
            }

        }

        return arr;
    }
}