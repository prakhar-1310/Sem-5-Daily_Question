class Solution {
    public int reverseDegree(String s) {
        int sum=0;
        for(int i=0;i<s.length();i++){
            int idx=i+1;
            int n = 'z'-s.charAt(i)+1;
            sum+=(idx*n);
        }

        return sum;
    }
}