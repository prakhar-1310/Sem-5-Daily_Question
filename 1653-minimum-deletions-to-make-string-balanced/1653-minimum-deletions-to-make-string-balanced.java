class Solution {
    public int minimumDeletions(String s) {
        Stack<Character> st = new Stack<>();
        int count=0;
        for(int i=0;i<s.length();i++){ //all b after all a
            if(!st.isEmpty() && st.peek()=='b' && s.charAt(i)=='a'){
                st.pop();
                count++;
            }
            else{
                st.push(s.charAt(i));
            }
        }
        return count;
    }
}