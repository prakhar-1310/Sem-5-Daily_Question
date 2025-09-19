class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
       
        
        int arr[] = new int [num1.length() + num2.length()];
        for (int i=num1.length()-1;i>=0;i--){
            for(int j=num2.length()-1;j>=0;j--){
                int res = (num1.charAt(i)-'0')*(num2.charAt(j)-'0') + arr[i+j+1];
                arr[i+j+1]=res%10;
                arr[i+j] += res/10;
            }
        }

        
        

        StringBuilder sb = new StringBuilder();
        
       
        for(int k : arr){
            if(sb.length()==0 && k==0){
                continue;
            }
            sb.append(k);
        }
        return sb.toString();

    }
}