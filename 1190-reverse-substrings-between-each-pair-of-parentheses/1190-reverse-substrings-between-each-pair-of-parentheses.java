class Solution {
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder(s);

        Stack<Integer>sta = new Stack<>();

        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='('){
                sta.push(i);
            }
            else if(sb.charAt(i)==')'){
                int st = sta.pop();
                StringBuilder tem = new StringBuilder(sb.substring(st, i+1));
                tem = tem.reverse();
                StringBuilder temp2 = new StringBuilder();
                temp2.append(sb.substring(0,st));
                temp2.append(tem);
                temp2.append(sb.substring(i+1));
                sb = new StringBuilder(temp2);
            }
        }

        StringBuilder ans = new StringBuilder();
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='(' || sb.charAt(i)==')'){

            }else{
                ans.append(sb.charAt(i));
            }
        }

        return ans.toString();
    }
}