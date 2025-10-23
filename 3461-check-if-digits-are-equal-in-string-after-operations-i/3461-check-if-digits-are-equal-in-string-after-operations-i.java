class Solution {
    public boolean hasSameDigits(String s) {
        String ans="";
        int i=0;
        while(s.length()>2 && i<s.length()-1){
            int a = s.charAt(i)-'0';
            int b = s.charAt(i+1)-'0';
            char ch = (char)((a+b)%10 +'0');
            ans+=ch;
            i++;
            if(i==s.length()-1){
                s=ans;
                ans="";
                i=0;
            }
        }
        return s.charAt(0)==s.charAt(1);
    }
}