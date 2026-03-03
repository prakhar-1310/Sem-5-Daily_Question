class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder("0");
        while(sb.length()<=k){
            String ext = helper(sb.toString());
            sb.append('1');
            sb.append(ext);
        }

        return sb.toString().charAt(k-1);
    }

    public String helper(String str){
        String s = revert(str);
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    public String revert(String str){
        StringBuilder sb = new StringBuilder();

        for(char i : str.toCharArray()){
            if(i=='0'){
                sb.append('1');
            }
            else{
                sb.append('0');
            }
        }

        return sb.toString();
    }
}