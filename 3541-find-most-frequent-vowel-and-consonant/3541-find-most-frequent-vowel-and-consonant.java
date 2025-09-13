class Solution {
    public int maxFreqSum(String s) {
        
        HashMap<Character,Integer>map1 = new HashMap<>();
        HashMap<Character,Integer>map2 = new HashMap<>();
        for(char ch : s.toCharArray()){
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                map1.put(ch,map1.getOrDefault(ch,0)+1);
            }
            else{
                map2.put(ch,map2.getOrDefault(ch,0)+1);
            }
        }
        int v=0;
        int c=0;
        for(int i : map1.values()){
            v=Math.max(v,i);
        }

        for(int i : map2.values()){
            c=Math.max(c,i);
        }

        return v+c;


    }
}