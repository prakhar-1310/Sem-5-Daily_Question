class Solution {
    public List<String> removeInvalidParentheses(String s) {
        HashSet<String>set = new HashSet<>();
        int n = s.length();
        int clo=0;
        int op=0;
        int bal=0;
        for(char ch : s.toCharArray()){
            if(ch=='(')bal++;
            else if(ch==')') bal--;

            if(bal<0){
                bal=0;
                clo++;
            }
        }
        op = bal;


        boolean tak[] = new boolean[n];
        helper(0, s, tak, set, op, clo);

        return new ArrayList<>(set);
    }

    public void helper(int idx, String s, boolean tak[], HashSet<String>set, int op, int clo){
        if(op==clo && op==0){
            check(s, tak, set);
            return;
        }

        for(int i=idx; i<s.length(); i++){
            if(s.charAt(i)=='(' && op>0){
                tak[i]=true;
                helper(i+1, s, tak, set, op-1, clo);
                tak[i]=false;
            }
            else if(s.charAt(i)==')' && clo>0){
                tak[i]=true;
                helper(i+1, s, tak, set, op, clo-1);
                tak[i]=false;
            }
        }
    }

    public void check(String s, boolean tak[], HashSet<String>set){
        boolean valid=true;
        int bal=0;
        StringBuilder sb =new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(tak[i])continue;
            char ch = s.charAt(i);
            sb.append(ch);
            if(ch=='(')bal++;
            else if(ch==')') bal--;

            if(bal<0){
                valid=false;
                break;
            }
        }
        if(bal>0)valid = false;

        if(valid){
            set.add(sb.toString());
        }
    }
}