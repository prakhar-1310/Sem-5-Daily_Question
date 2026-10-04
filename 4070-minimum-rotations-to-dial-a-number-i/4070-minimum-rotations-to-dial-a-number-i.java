class Solution {
    public int minRotations(String s) {
        int tot=0;
        char prev='0';
        for(char ch : s.toCharArray()){
            int min = Math.min(Math.abs(ch-prev), Math.min(
                Math.abs('9'-prev)+1+ch-'0', Math.abs(prev-'0')+1+'9'-ch)
                );
            tot+=min;
            prev=ch;
        }

        return tot;
    }
}