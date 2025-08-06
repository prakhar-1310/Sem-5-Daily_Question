class Solution {
    public int getKth(int lo, int hi, int k) {
        int ans[][] = new int [hi-lo+1][2];
        int j=0;
        for(int i=lo;i<=hi;i++){
            ans[j][0]=i;
            ans[j++][1]=power(i);
        }
        Arrays.sort(ans, (a,b)->{
            return a[1]-b[1];
        });
        return ans[k-1][0];
        
    }

    private int power(int n){
        int count=0;
        while(n!=1){
            if(n%2==0){
                n = n/2;
            }
            else{
                n = (n*3)+1;
            }
            count++;
        }
        return count;
    }
}