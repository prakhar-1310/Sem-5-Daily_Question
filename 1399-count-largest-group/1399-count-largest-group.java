class Solution {
    public int countLargestGroup(int n) {
        HashMap<Integer,Integer>map = new HashMap<>();
        // sum , count
        for(int i=1;i<=n;i++){
            int sum = helper(i);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }

        int max=map.get(1);
        int count=0;
        for(int i : map.values()){
            if(max == i){
                count++;
            }
            else if (i>max){
                count=1;
                max=i;
            }
        }
        return count;
    }
    private int helper(int n){
        int sum=0;
        while(n>0){
            sum+=n%10;
            n/=10;
        }
        return sum;
    }
}