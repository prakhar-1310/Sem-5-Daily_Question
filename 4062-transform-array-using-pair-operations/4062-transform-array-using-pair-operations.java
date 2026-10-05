class Solution {
    public boolean canTransform(int[] source, int[] target) {
        long tot1=0;
        long tot2=0;
        for(int i : source){
            tot1+=i;
        }

        for(int i : target){
            tot2+=i;
        }

        return tot1==tot2;
    }
}