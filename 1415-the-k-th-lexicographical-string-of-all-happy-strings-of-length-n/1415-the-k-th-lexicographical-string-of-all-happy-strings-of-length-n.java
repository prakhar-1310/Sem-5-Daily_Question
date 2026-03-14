class Solution {
    public String getHappyString(int n, int k) {
        helper(n,"");
        return list.size()<k ?"" : list.get(k-1);
    }
    List<String>list=new ArrayList<>();

    public void helper(int n, String ans){
        if(ans.length()==n){
            list.add(ans);
            return;
        }

        if(ans.length()==0){
            helper(n, ans+"a");
            helper(n, ans+"b");
            helper(n, ans+"c");
        }
        else{
            if(ans.charAt(ans.length()-1)=='a'){
                helper(n, ans+"b");
                helper(n, ans+"c");
            }
            else if(ans.charAt(ans.length()-1)=='b'){
                helper(n, ans+"a");
                helper(n, ans+"c");
            }
            else{
                helper(n, ans+"a");
                helper(n, ans+"b");
            }
        }

    }
}