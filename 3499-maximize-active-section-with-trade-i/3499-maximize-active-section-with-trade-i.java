class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int b=0;
        for (char c : s.toCharArray()){
            if (c=='1'){
                b++;
            }
        }
        String str = "1"+s+"1";
        int m = str.length();
        int res=b;
        for (int i=1;i<m-1;){
            if (str.charAt(i)=='1'){
                int j=i;
                while (j<m && str.charAt(j)=='1'){
                    j++;
                }
                if (j<m-1 && str.charAt(i-1)=='0' && str.charAt(j)=='0'){
                    int a =0;
                    int c=0;
                    int k=i-1;
                    while(k>=0 && str.charAt(k)=='0'){
                        a++;
                        k--;
                    }
                    k=j;
                
                    while (k<m && str.charAt(k)=='0'){
                        c++;
                        k++;
                    }
                    res= Math.max(res,b+a+c);
                }
            
                i=j;
            }
        
            else{
                i++;
            }
        }
        return res;
    }

}