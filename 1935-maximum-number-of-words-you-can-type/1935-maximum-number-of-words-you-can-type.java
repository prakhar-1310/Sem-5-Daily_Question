class Solution {
    public int canBeTypedWords(String text, String bl) {
        int count=0;
        String arr[] = text.split(" ");
        for(String i : arr){
            for(char ch : bl.toCharArray()){
                if(i.contains(ch+"")){
                    count++;
                    break;
                }
            }
        }
        return arr.length-count;
    }
}