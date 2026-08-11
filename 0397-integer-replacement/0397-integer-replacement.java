class Solution {
    public int integerReplacement(int n) {
        HashMap<Long,Long>map = new HashMap<>();
        return (int)helper(n, map);
    }

    public long helper(long n, HashMap<Long,Long>map){
        if(n==1){
            return 0;
        }
        if(map.containsKey(n))return map.get(n);
        long ans=0;
        if(n%2==0){
            ans = helper(n/2,map);
        }
        else{
            long opt1 = helper(n+1,map);
            long opt2 = helper(n-1,map);
            ans = Math.min(opt1, opt2);
        }
        map.put(n, ans+1);
        return ans+1;
    }
}