class Solution {
    public int minMovesToMakePalindrome(String s) {
        int cnt=0;
        while(s.length()>2){
            char st = s.charAt(0);
            char ed = s.charAt(s.length()-1);

            if(st==ed){
                s = s.substring(1,s.length()-1);
            }

            else{
                int id1 = s.lastIndexOf(st);
                int id2 = s.indexOf(ed);

                int step1 = s.length()-1-id1;//replace id1 index character with last
                int step2 = id2;// replace first character with id2 index character
                int len = s.length();
                StringBuilder sb = new StringBuilder();
                if (step1 > step2) {
                    cnt += step2;
                    sb.append(s.substring(0, id2));
                    sb.append(s.substring(id2 + 1, len - 1));
                } else {
                    cnt += step1;
                    sb.append(s.substring(1, id1));
                    sb.append(s.substring(id1 + 1));
                }

                s = sb.toString();
            }
        }

        return cnt;
    }
}
// UML diagram
// relation, association, agrregation
// is a, has 
// elevator system
// class diagram-> methods, public +, private -, protected #
// singleton design pattern