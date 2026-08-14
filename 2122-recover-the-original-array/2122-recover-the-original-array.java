class Solution {
    public int[] recoverArray(int[] nums) {
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }

        List<Integer>grp1 = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer>kL = new ArrayList<>();
        for(int i : nums){
            if((i-nums[0])%2==0){
                kL.add((i-nums[0])/2);
            }
        }

        System.out.println(kL);

        List<Integer>list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        int finK=-1;
        for(int k : kL){
            int size=0;
            HashMap<Integer,Integer>temp = new HashMap<>(map);
            for(int key : list){
                int l = key;
                int r = key + (2*k);
                if(temp.get(l)!=0 && temp.containsKey(r) && temp.get(l)<=temp.get(r)){
                    int min = Math.min(temp.get(l),temp.get(r));
                    temp.put(l,temp.get(l)-min);
                    temp.put(r,temp.get(r)-min);
                    size+=min;
                }
            }

            if(size==nums.length/2){
                finK=k;
                break;
            }
        }

        System.out.println(finK);

        int ans[] = new int[nums.length/2];
        int idx=0;
            for(int key : list){
                int l = key;
                int r = key + (2*finK);
                if(map.get(l)!=0 && map.containsKey(r) && map.get(l)<=map.get(r)){
                    int min = Math.min(map.get(l),map.get(r));
                    map.put(l,map.get(l)-min);
                    map.put(r,map.get(r)-min);
                    for(int t =0;t<min;t++){
                        ans[idx++]=key+finK;
                    }
                    
                }
                
            }
        

        return ans;
    }
}