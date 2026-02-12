class Solution {
    public int longestBalanced(String s) {
        int ans=0;
        HashMap<Character,Integer>map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map = new HashMap<>();
            for(int j=i;j<s.length();j++){
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j),0)+1);
                int val = map.get(s.charAt(j));
                boolean flag=true;
                for(int k : map.values()){
                    if(val!=k){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    ans=Math.max(ans,j-i+1);
                }
            }
        }
        return ans;
    }
}