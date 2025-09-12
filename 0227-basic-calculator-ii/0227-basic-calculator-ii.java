class Solution {
    public int calculate(String s) {
        Stack<Integer>st = new Stack<>();
        int curr =0;
        char op ='+';

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                curr = curr*10 + (ch-'0');
            }
            if((!Character.isDigit(ch) && ch!=' ' )|| i==s.length()-1){
                if (op=='+'){
                    st.push(curr);
                    curr=0;
                }
                else if (op=='-'){
                    st.push(curr*-1);
                    curr=0;
                }
                else if (op=='*'){
                    st.push(st.pop()*curr);
                    curr=0;
                }
                else if (op=='/'){
                    st.push(st.pop()/curr);
                    curr=0;
                }
                op = ch;
            }  
        }
        
        int sum=0;
        while(!st.isEmpty()){
            sum+=st.pop();
        }
        return sum;
    }
}