class Solution {
    public String generateTag(String caption) {
        StringBuilder sb = new StringBuilder("#");
        sb.append(Character.toLowerCase(caption.charAt(0)));
        
        for(int i=1;i<caption.length();i++){
            char ch = caption.charAt(i);
            if(Character.isAlphabetic(ch)){
                sb.append(Character.toLowerCase(ch));
            }
            else if(ch==' '){
                if(i+1<caption.length()){
                    i++;
                    sb.append(Character.toUpperCase(caption.charAt(i)));
                }
            }
        }
        String ans = sb.toString();
        if(ans.length()>100){
            return ans.substring(0,100);
        }
        return ans;
    }
}