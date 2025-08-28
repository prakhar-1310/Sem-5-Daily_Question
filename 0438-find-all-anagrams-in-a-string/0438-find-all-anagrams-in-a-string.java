class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>list = new ArrayList<>();
        HashMap<Character,Integer>map = new HashMap<>();
        if(p.length()>s.length()){
            return list;
        }
        for(char i : p.toCharArray()){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        
        int start=0;
        int end = p.length();
        HashMap<Character,Integer>map2 = new HashMap<>();
        for(int i=start;i<end;i++){
            map2.put(s.charAt(i), map2.getOrDefault(s.charAt(i),0)+1);
        }
        
        if(map.equals(map2)){
            list.add(start);
        }

        for(int i = end;i<s.length();i++){
            char st = s.charAt(start);
            map2.put(st, map2.get(st)-1);
            if (map2.get(st) == 0) {
                map2.remove(st);
            }
            start++;
            
            char ch = s.charAt(i);
            map2.put(ch, map2.getOrDefault(ch,0)+1);
            
            if(map.equals(map2)){
                list.add(start);
            }
            
        }

        return list;
    }  
}