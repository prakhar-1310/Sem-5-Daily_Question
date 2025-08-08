class Solution {
    public boolean isAcronym(List<String> words, String s) {
        StringBuilder sb = new StringBuilder();
        for (String word : words){
            sb.append(word.charAt(0));
        }

        if (sb.toString().equals(s)){
            return true;
        }

        return false;
    }
}