class Solution {
    public boolean canRemoveAll(int[] types, int[] colors, int[] groupSize) {
        Stack<Pair>st = new Stack<>();
        int n = types.length;

        for(int i=0;i<n;i++){
            if(groupSize[types[i]]==1){
                continue;
            }
            if(!st.isEmpty() && types[st.peek().val] == types[i] && colors[st.peek().val]==colors[i]){
                if(st.peek().size+1==groupSize[types[i]]){
                    int count = st.peek().size;

                    for(int j=0;j<count;j++){
                        st.pop();
                    }
                }
                else{
                    st.push(new Pair(i, st.peek().size + 1));
                }
            }
            else{
                st.push(new Pair(i, 1));
            }
        }

        return st.isEmpty();
    }

    class Pair{
        int val; // index
        int size;

        public Pair(int val, int size){
            this.val=val;
            this.size=size;
        }
    }
}