class Solution {
    public boolean asteroidsDestroyed(int mass, int[] ast) {
        Arrays.sort(ast);
        long m = (long)mass;
        for(int i : ast){
            if(i>m)return false;
            m+=i;
        }

        return true;
    }
}