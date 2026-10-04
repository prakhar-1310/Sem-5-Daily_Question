class Solution {
    public int minRotations(int n, String s) {
        int tot=0;
        char prev='0';
        int gain = 0;
        for(int i=0;i<s.length();i++){
            // gain calculation
            char ch = s.charAt(s.length()-1);

            int opt2 = Math.min(Math.abs(ch-prev), Math.min(
                Math.abs('9'-prev)+1+ch-'0', Math.abs(prev-'0')+1+'9'-ch)
                );
            


            ch = s.charAt(i);
            int min = Math.min(Math.abs(ch-prev), Math.min(
                Math.abs('9'-prev)+1+ch-'0', Math.abs(prev-'0')+1+'9'-ch)
                );
            tot+=min;

            gain = Math.max(gain, min-opt2);
            
            prev=ch;
        }

        return tot-gain;
    }
}