class Solution {
    public String sortVowels(String s) {
        List<Character> vow = new ArrayList<>();
        for (char ch : s.toCharArray()){
            if (ch=='a'|| ch=='e'|| ch=='i'|| ch=='o'|| ch=='u'|| ch=='A'|| ch=='E'|| ch=='I'|| ch=='O'|| ch=='U'){
                vow.add(ch);
            }
        }
        Collections.sort(vow);
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()){
            if (ch=='a'|| ch=='e'|| ch=='i'|| ch=='o'|| ch=='u'|| ch=='A'|| ch=='E'|| ch=='I'|| ch=='O'|| ch=='U'){
                sb.append(vow.get(0));
                vow.remove(0);
            }
            else{
                sb.append(ch);
            }
        }
        return sb.toString();

    }
}