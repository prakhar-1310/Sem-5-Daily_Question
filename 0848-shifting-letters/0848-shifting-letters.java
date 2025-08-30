class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        shifts[shifts.length-1]%=26;
        for (int i=shifts.length-2;i>=0;i--){
            shifts[i]+= shifts[i+1];
            shifts[i]%=26;
        }
        char arr[] = s.toCharArray();
        for (int i=0;i<shifts.length;i++){
            arr[i]=(char)((arr[i]-'a'+shifts[i])%26+'a');
        }
        StringBuilder sb = new StringBuilder("");
        for (int i=0;i<arr.length;i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}