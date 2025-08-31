class Solution {
    public List<String> addOperators(String num, int target) {
        List<String>ll = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(num,0,ll,target,sb,0);
        return ll;
    }
    public static void helper(String num, long curr, List<String>ll, int target, StringBuilder ans, long prev){
        if( num.length()==0 ){
            if(curr==target){
                ll.add(ans.toString());
            }
            return;
        }
        
        for(int cut=1;cut<=num.length();cut++){
            String s = num.substring(0,cut);
            if (s.length() > 1 && s.charAt(0) == '0') break;
            int len = s.length();
            long n = Long.parseLong(s);

            if(ans.length()==0){
                helper(num.substring(cut),n,ll,target,ans.append(n),n);
                ans.delete(ans.length()-len,ans.length());
            }
            else{
                
                helper(num.substring(cut),curr+n,ll,target,ans.append("+"+n),n);
                ans.delete(ans.length()-len-1,ans.length());
                helper(num.substring(cut),curr-n,ll,target,ans.append("-"+n),-n);
                ans.delete(ans.length()-len-1,ans.length());
                helper(num.substring(cut),curr-prev + prev*n,ll,target,ans.append("*"+n),prev*n);
                ans.delete(ans.length()-len-1,ans.length());
            }
            
        }
        
    }
}