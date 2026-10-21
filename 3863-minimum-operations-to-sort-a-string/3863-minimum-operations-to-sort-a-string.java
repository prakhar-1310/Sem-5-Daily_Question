class Solution {
    public int minOperations(String s) {
        int n = s.length();
        // if already sorted
        boolean sorted = true;
        for(int i=1;i<n;i++){
            if(s.charAt(i-1)>s.charAt(i)){
                sorted=false;
                break;
            }
        }

        if(sorted) return 0;

        // not sorted as well as of length 2 means not possible
        if(s.length()==2) return -1;


        // if first caharcter is smallest or last character is largest
        // then only 1 operation needed
        char first = s.charAt(0);
        boolean f = true;
        char last = s.charAt(n-1);
        boolean l = true;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch>last){
                l = false;
            }
            if(ch<first){
                f = false;
            }
        }

        if(f || l) return 1;

        // (one and only largest character at first) and (one and only smallest       character at last) -> return 3
        // otherwise return  2

        first = s.charAt(0);
        f = true;
        int freqF=0;
        last = s.charAt(n-1);
        l = true;
        int freqL=0;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch<last){
                l = false;
            }
            if(ch>first){
                f = false;
            }

            if(first==ch){
                freqF++;
            }

            if(last == ch){
                freqL++;
            }
        }

        if((l && freqL==1) && (f && freqF==1)){
            return 3;
        }
        

        return 2;
    }
}