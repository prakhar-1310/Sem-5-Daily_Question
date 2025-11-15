class Solution {
    public int numberOfSubstrings(String s) {
        int countZero[] = new int[s.length()];
        countZero[0] = (s.charAt(0)=='0')?1:0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='0'){
                countZero[i]=countZero[i-1]+1;
            }
            else{
                countZero[i]=countZero[i-1];
            }
        }

        int count=0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                int zero=countZero[j]-((i!=0)?countZero[i-1]:0);
                int one = j-i+1 - zero;

                if(one==(zero*zero)){
                    count++;
                }
                else if (one>(zero*zero)){
                    count++;
                    int k = (int)(Math.sqrt(one))-zero;
                    int next = k + j;
                    if(next>=s.length()){
                        count+=s.length()-j-1;
                        break;
                    }
                    else{
                        count+=k;
                    }
                    j = next;
                }
                else if (one<(zero*zero)){
                    int k = zero*zero - one;
                    j+=k-1;
                }
            }
        }

        return count;
    }
}