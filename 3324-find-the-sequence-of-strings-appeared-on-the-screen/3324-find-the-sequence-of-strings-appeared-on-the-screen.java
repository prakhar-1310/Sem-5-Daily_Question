class Solution {
    public List<String> stringSequence(String target) {
        List<String>list = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
        while(sb.length()!=target.length()){
            sb.append('a');
            list.add(sb.toString());
            while(sb.charAt(sb.length()-1)!=target.charAt(sb.length()-1)){
                sb.setCharAt(sb.length()-1, (char)(sb.charAt(sb.length()-1)+1));
                list.add(sb.toString());
            }
        }

        return list;
    }
}