class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>list = new ArrayList<>();
        helper(n,list,"",0,0);
        return list;
    }

    public void helper(int n, List<String>list, String ans, int open, int close){
        if(open==n && close==n){
            list.add(ans);
            return;
        }
        
        if(open>n || open<close){
            return;
        }

        helper(n, list, ans+"(", open+1,close);
        helper(n,list,ans+")",open,close+1);
        
    }
}