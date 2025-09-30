class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        HashMap<Character,Integer>map = new HashMap<>();
        for(char ch : s1.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        HashMap<Character,Integer>map2 = new HashMap<>();
        for(int i=0;i<s1.length();i++){
            char ch = s2.charAt(i);
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }

        if(map.equals(map2)){
            return true;
        }

        int left=0;
        for(int right=s1.length();right<s2.length();right++){
            char ch = s2.charAt(right);
            map2.put(ch,map2.getOrDefault(ch,0)+1);

            char ch2 = s2.charAt(left);
            left++;
            map2.put(ch2,map2.get(ch2)-1);
            if(map2.get(ch2)==0){
                map2.remove(ch2);
            }

            if(map.equals(map2)){
                return true;
            }
        }

        return false;
    }
}