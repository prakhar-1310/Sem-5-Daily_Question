class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character,Integer>map = new HashMap<>();
        for(char ch : "balon".toCharArray()){
            map.put(ch,0);
        }

        for(char ch : text.toCharArray()){
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
            }
        }

        int min = Integer.MAX_VALUE;

        for(char ch : map.keySet()){
            if(ch=='l' || ch=='o'){
                min=Math.min(min,map.get(ch)/2);
            }
            else{
                min=Math.min(min,map.get(ch));
            }
        }

        return min==Integer.MIN_VALUE ? 0 : min;
    }
}