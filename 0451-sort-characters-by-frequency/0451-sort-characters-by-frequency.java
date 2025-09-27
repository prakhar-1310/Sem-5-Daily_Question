class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char i : s.toCharArray()){
            map.put(i, map.getOrDefault(i,0)+1);
        }

        List<Character>list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a,b)->map.get(b)-map.get(a));
        StringBuilder sb = new StringBuilder();
        for(char i : list){
            for(int j =0 ;j<map.get(i);j++){
                sb.append(i);
            }
            
        }
        return sb.toString();
    }
}