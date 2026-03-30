class Solution {
    public boolean checkStrings(String s1, String s2) {
        List<Character>ev1 = new ArrayList<>();
        List<Character>od1 = new ArrayList<>();
        List<Character>ev2 = new ArrayList<>();
        List<Character>od2 = new ArrayList<>();

        for(int i=0;i<s1.length();i++){
            if(i%2==0){
                ev1.add(s1.charAt(i));
                ev2.add(s2.charAt(i));
            }
            else{
                od1.add(s1.charAt(i));
                od2.add(s2.charAt(i));
            }
        }

        Collections.sort(ev1);
        Collections.sort(od1);
        Collections.sort(ev2);
        Collections.sort(od2);

        
        if((ev1.equals(ev2)) && (od1.equals(od2))){
            return true;
        }

        return false;
    }
}