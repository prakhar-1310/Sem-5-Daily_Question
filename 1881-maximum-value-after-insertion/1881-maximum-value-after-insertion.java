class Solution {
    public String maxValue(String n, int x) {
        char ins = (char)(x+'0');
        StringBuilder sb = new StringBuilder();
        
        if (n.charAt(0)=='-'){
            int i=1;
            sb.append('-');
            while(i<n.length() && n.charAt(i)<=ins ){
                sb.append(n.charAt(i));
                i++;
            }
            sb.append(ins);

            while(i<n.length()){
                sb.append(n.charAt(i));
                i++;
            }

        }

        else{
            int i=0;
            while(i<n.length() && n.charAt(i)>=ins ){
                sb.append(n.charAt(i));
                i++;
            }
            sb.append(ins);

            while(i<n.length()){
                sb.append(n.charAt(i));
                i++;
            }

        }

        return sb.toString();
    }
}