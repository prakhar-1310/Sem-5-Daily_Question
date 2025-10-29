class Solution {
    public int smallestNumber(int n) {
        int num=0;
        int mul=1;
        int dig=0;
        // devide and modulu by desti
        // multi by source
        while (n>0){ // source->10; desti-> binary
            int rem = n%2;
            n=n/2;
            num = num+rem*mul;
            dig++;
            mul*=10;
        }
        int target=0;
        for (int i=0;i<dig;i++){
            target=target*10+1;
        }
        int ans=0;
        mul=1;
        while (target>0){
            int rem = target%10;
            target/=10;
            ans+=rem*mul;
            mul*=2;
        }
        return ans;
        
    }
}