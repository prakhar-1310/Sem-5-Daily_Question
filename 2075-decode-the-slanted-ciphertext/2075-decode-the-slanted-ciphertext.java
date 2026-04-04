class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        StringBuilder sb = new StringBuilder();
        int n = encodedText.length();
        int col = n/rows;

        for(int c=0;c<col;c++){
            int r=0;
            int j=c;
            while(j<col && r<rows){
                sb.append(encodedText.charAt(r*col+j));
                j++;
                r++;
            }
        }

        for(int i=sb.length()-1;i>=0;i--){
            if(sb.charAt(i)!=' '){
                return sb.substring(0,i+1);
            }
        }

        return sb.toString();
    }
}