class Solution {
    public int numberOfSpecialChars(String word) {
        HashSet<Character>set = new HashSet<>();

        for(char ch : word.toCharArray()){
            set.add(ch);
        }

        int cnt=0;

        for(char ch : set){
            if(set.contains((char)(ch+32)) || set.contains((char)(ch-32))){
                cnt++;
            }
        }

        return cnt/2;
    }
}