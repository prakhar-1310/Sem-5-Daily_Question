class Solution {
    public int maximumLength(String s) {
        HashMap<String, Integer>map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                String str = s.substring(i,j);
                map.put(str,map.getOrDefault(str,0)+1);
            }
        }

        int ans=-1;

        for(String key : map.keySet()){
            if(map.get(key)>=3){
                HashSet<Character>set = new HashSet<>();

                for(char ch : key.toCharArray()){
                    set.add(ch);
                }

                if(set.size()==1){
                    ans=Math.max(ans,key.length());

                }
            }
        }

        return ans;
    }
}