class Solution {
    public long countCompleteDayPairs(int[] hours) {
        long mod12=0;
        long mod24=0;
        HashMap<Integer, Long>map = new HashMap<>();
        for(int i : hours){
            if(i%24==0){
                mod24++;
            }
            else if(i%12==0){
                mod12++;
            }
            else{
                map.put(i%24, map.getOrDefault(i%24,0L)+1);
            }
        }

        long tot = mod24*(mod24-1)/2 + mod12*(mod12-1)/2;
        HashSet<Integer>set = new HashSet<>(map.keySet());
        for(int i : set){
            int a = i;
            long freqA = map.getOrDefault(a,0L);
            int b = 24-i;
            long freqB = map.getOrDefault(b,0L);
            tot+=freqA*freqB;
            map.put(a,0L);
            map.put(b,0L);
        }

        return tot;
    }

}