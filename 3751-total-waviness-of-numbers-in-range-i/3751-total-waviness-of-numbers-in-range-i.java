class Solution {
    public int totalWaviness(int num1, int num2) {
        int count=0;
        for(int i=num1;i<=num2;i++){
            String s = i+"";
            for(int j=1;j<=s.length()-2;j++){
                if(s.charAt(j)-'0'>s.charAt(j-1)-'0' &&s.charAt(j)-'0'>s.charAt(j+1)-'0'){
                    count++;
                }
                else if(s.charAt(j)-'0'<s.charAt(j-1)-'0' &&s.charAt(j)-'0'<s.charAt(j+1)-'0'){
                    count++;
                }
            }
        }

        return count;
    }
}