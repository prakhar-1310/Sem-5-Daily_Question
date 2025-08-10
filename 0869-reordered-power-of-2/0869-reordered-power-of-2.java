class Solution {
    public boolean reorderedPowerOf2(int n) {
        String str = sorted(n);
        int num =2;
        if(n==1 || n==2){
            return true;
        }
        for(int i=2;i<=29;i++){
            num*=2;
            if(str.equals(sorted(num))){
                return true;
            }
        }
        return false;
    }

    private String sorted(int n){
        char arr[] = (n+"").toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}