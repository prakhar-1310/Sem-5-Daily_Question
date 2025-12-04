class Solution {
    public int countCollisions(String directions) {
        int count=0;
        Stack<Character>st = new Stack<>();
        for(char ch : directions.toCharArray()){
            
            if(ch=='R'){
                st.push(ch);
            }
            else if(ch=='S'){
                while(!st.isEmpty() && st.peek()=='R'){
                    st.pop();
                    count++;
                }
                st.push('S');
            }
            else if(ch=='L'){
                if(st.isEmpty()){
                    st.push(ch);
                }
                else if(st.peek()=='S'){
                    count++;
                }
                else if(st.peek()=='R'){
                    st.pop();
                    count+=2;
                    while(!st.isEmpty() && st.peek()=='R'){
                        st.pop();
                        count++;
                    }
                    st.push('S');
                }
                else{
                    st.push('L');
                }
            }
        }

        return count;
    }
}