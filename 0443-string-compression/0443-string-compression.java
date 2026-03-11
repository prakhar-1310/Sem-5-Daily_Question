class Solution {
    public int compress(char[] chars) {
        // String s = Array.toString(chars);
        int k=0;
        for (int i=0;i<chars.length;){
            int count=1;
            for (int j=i+1;j<chars.length;j++){
                if (chars[i]==chars[j]){
                    count++;
                }
                else{
                    break;
                }
            }
            chars[k]=chars[i];
            k++;
            i+=count;
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[k++] = c;
                }
            }
        }
        return k;
    }
}