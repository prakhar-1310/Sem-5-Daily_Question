class Solution {
    public int[] getNoZeroIntegers(int n) {
        int arr[] = new int[2];
        for(int i=1;i<n;i++){
            int a = i;
            int b = n-i;
            if(check(a) && check(b)){
                arr[0]=a;
                arr[1]=b;
                return arr;
            }
        }
        return new int[2];
    }

    public static boolean check(int num){
        while(num>0){
            if(num%10==0){
                return false;
            }
            num/=10;
        }
        return true;
    }
}
