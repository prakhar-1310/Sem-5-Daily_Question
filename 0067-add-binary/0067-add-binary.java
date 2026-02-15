class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int carry =0;
        int i = a.length()-1;
        int j = b.length()-1;

        while(i>=0 || j>=0){
            int sum=0;
            if(i>=0){
                sum+=a.charAt(i)-'0';
                i--;
            }

            if(j>=0){
                sum+=b.charAt(j)-'0';
                j--;
            }

            sum+=carry;
            carry = sum/2;
            sb.append(sum%2);
        }

        if(carry==1){
            sb.append(1);
        }

        return sb.reverse().toString();
    }
}