class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String>dict = new HashSet<>(wordDict);
        List<String>list = new ArrayList<>();
        helper(0,s,list,dict,"");
        return list;
    }

    public void helper(int i, String s, List<String>list, HashSet<String>dict, String ans){
        if(i==s.length()){
            list.add(ans.trim());
            return;
        }

        for(int j=i+1;j<=s.length();j++){
            String sub = s.substring(i,j);
            if(dict.contains(sub)){
                helper(j,s,list,dict,ans+sub+" ");
            }
        }
        return;
    }
}