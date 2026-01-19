class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer>st = new Stack<>();
        for(String i : operations){
            if(Character.isDigit(i.charAt(0))|| i.charAt(0)=='-'){
                st.push(Integer.parseInt(i));
            }
            else if(i.equals("+")){
                int val = st.pop();
                int val2 = st.pop();
                int val3 = val+val2;
                st.push(val2);
                st.push(val);
                st.push(val3);
            }
            else if (i.equals("D")){
                int val = st.peek();
                st.push(2*val);
            }
            else if (!st.isEmpty() && i.equals("C")){
                st.pop();
            }
        }

        int sum=0;
        for(int i : st){
            sum+=i;
        }

        return sum;
    }
}