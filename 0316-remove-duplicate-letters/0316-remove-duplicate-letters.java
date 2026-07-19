class Solution {
    public String removeDuplicateLetters(String s) {
        int lastInd[] = new int[26];
        for(int i=0;i<s.length();i++){
            lastInd[s.charAt(i)-'a']=i;
        }

        Stack<Character>st = new Stack<>();
        HashSet<Character>set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(set.contains(ch))continue;
            while(!st.isEmpty() && st.peek()>ch && lastInd[st.peek()-'a']>i){
                set.remove(st.peek());
                st.pop();
            }

            
                set.add(ch);
                st.push(ch);
            
            
        }

        StringBuilder sb = new StringBuilder();
        for(char ch : st){
            sb.append(ch);
        }

        return sb.toString();
    }
}