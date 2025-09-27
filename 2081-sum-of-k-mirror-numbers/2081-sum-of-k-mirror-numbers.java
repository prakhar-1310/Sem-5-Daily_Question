class Solution {
    public long kMirror(int k, int n) {
        long sum=0;
        int len=1;
        int count=0;
        while(count!=n){
            int half=(len+1)/2;
            if(len%2!=0){
                for(int i=(int)(Math.pow(10,half-1));i<=(int)(Math.pow(10,half)-1) && count<n;i++){
                    StringBuilder first = new StringBuilder(Integer.toString(i));
                    StringBuilder second = new StringBuilder(first).reverse().deleteCharAt(0); 
                    String pal = first.append(second).toString();
                    if(palin(pal,k)){
                        sum+=Long.parseLong(pal);
                        count++;
                    }
                }
            }

            else{
                for(int i=(int)(Math.pow(10,half-1));i<=(int)(Math.pow(10,half)-1) && count<n;i++){
                    StringBuilder first = new StringBuilder(Integer.toString(i));
                    StringBuilder second = new StringBuilder(first).reverse(); 
                    String pal = first.append(second).toString();
                    if(palin(pal,k)){
                        sum+=Long.parseLong(pal);
                        count++;
                    }
                }
            }
            len++;

        }
        return sum;
        
    }

    public static boolean palin(String n,int k){
        long temp = Integer.parseInt(n);
        StringBuilder num=new StringBuilder();
        while(temp>0){
            long rem = temp%k;
            num.append(rem);
            temp/=k;
        }

        String str = num.toString();
        int i=0;
        int j = str.length()-1;
        while(i<=j){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}