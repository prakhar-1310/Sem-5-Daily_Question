class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String str1 = strs[0];
        String str2 = strs[strs.length-1];
        int i =0;
        StringBuilder pre = new StringBuilder();
        while (i<str1.length()){
            if (str1.charAt(i)==str2.charAt(i)){
                pre.append(str1.charAt(i));
                i++;
            }
            else{
                break;
            }
        }
        return pre.toString();
}}