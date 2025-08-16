class Solution {
    public int maximum69Number (int num) {
        String str = ""+num;
        StringBuilder sb = new StringBuilder ();
        int c=0;
        for (int i=0;i<str.length();i++){
            if (c==0 && str.charAt(i)=='6'){
                sb.append('9');
                c++;
            }
            else{
                sb.append(str.charAt(i));
            }
        }
        String s = sb.toString();
        return Integer.parseInt(s);
    }
}