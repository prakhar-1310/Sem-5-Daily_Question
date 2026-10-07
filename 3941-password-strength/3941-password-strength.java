class Solution {
    public int passwordStrength(String password) {
        HashSet<Character>small = new HashSet<>();
        HashSet<Character>capital = new HashSet<>();
        HashSet<Character>num = new HashSet<>();
        HashSet<Character>spec = new HashSet<>();

        for(char ch : password.toCharArray()){
            if(Character.isLowerCase(ch)){
                small.add(ch);
            }
            else if(Character.isUpperCase(ch)){
                capital.add(ch);
            }
            else if(Character.isDigit(ch)){
                num.add(ch);
            }
            else{
                spec.add(ch);
            }
        }

        return small.size()*1 + capital.size()*2 + num.size()*3 + spec.size()*5;
    }
}