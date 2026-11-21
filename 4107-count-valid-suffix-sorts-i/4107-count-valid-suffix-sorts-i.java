class Solution {
    public int countSuffix(int[] nums, int[] target) {
        int n = nums.length;
        int temp = n-1;
        HashMap<Integer, Integer>map = new HashMap<>();
        map.put(target[n-1], 1);
        for(int i=n-2;i>=0;i--){
            if(target[i]<target[i+1]){
                break;
            }
            else{
                map.put(target[i], map.getOrDefault(target[i],0)+1);
                temp=i;
            }
        }

        for(int i=n-1;i>=temp;i--){
            if(!map.containsKey(nums[i])){
                return 0;
            }

            if(map.get(nums[i])==1){
                map.remove(nums[i]);
            }
            else{
                map.put(nums[i], map.get(nums[i])-1);
            }
        }

        for(int i=0;i<temp;i++){
            if(nums[i]!=target[i])return 0;
        }

        int cnt=0;
        System.out.println(temp);
        for(int i=temp;i<n;i++){
            if(nums[i]==target[i]){
                cnt++;
            }
            else if(nums[i]<target[i]){
                cnt++;
                break;
            }
            else{
                break;
            }
        }

        return cnt;
    }
}