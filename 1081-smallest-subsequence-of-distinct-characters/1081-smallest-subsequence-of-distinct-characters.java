class Solution {
    public String smallestSubsequence(String s) {
        int lastInd[] = new int[26];
        for(int i=0;i<s.length();i++){
            lastInd[s.charAt(i)-'a']=i;
        }

        Stack<Character>st = new Stack<>();
        boolean bol[] = new boolean[26];
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(bol[ch-'a'])continue;
            while(!st.isEmpty() && st.peek()>ch && lastInd[st.peek()-'a']>i){
                bol[st.peek()-'a']=false;
                st.pop();
            }
            bol[ch-'a']=true;
            st.push(ch);
        }

        StringBuilder sb = new StringBuilder();
        for(char ch : st){
            sb.append(ch);
        }

        return sb.toString();
    }
}