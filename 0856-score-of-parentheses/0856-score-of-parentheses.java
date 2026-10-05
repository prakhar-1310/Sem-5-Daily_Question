class Solution {
    public int scoreOfParentheses(String s) {
        int tot=0;
        int stage=0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch=='('){
                stage++;
            }
            else{
                stage--;
                if (s.charAt(i - 1) == '(') {
                    tot += 1 << stage;
                }   
            }
        }

        return tot;
    }
}