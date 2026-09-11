class Solution {
    public int totalNumbers(int[] digits) {
        HashMap<Integer, Integer>map = new HashMap<>();
        int ev=0;
        int zero=0;
        for(int i : digits){
            if(i%2==0){
                ev++;
            }
            if(i==0){
                zero++;
            }
            if(!map.containsKey(i)){
                map.put(i,0);
            }
            map.put(i, map.get(i)+1);
        }

        int tot=0;
        for(int last=0; last<=8; last+=2){
            if(!map.containsKey(last))continue ;
            map.put(last, map.get(last)-1);
            for(int first=1; first<=9; first++){
                if(!map.containsKey(first))continue;
                if(map.get(first)==0)continue;
                map.put(first, map.get(first)-1);
                for(int second=0;second<=9;second++){
                    if(!map.containsKey(second))continue;
                    if(map.get(second)==0)continue;

                    tot++;

                    
                }

                map.put(first, map.get(first)+1);
            }

            map.put(last, map.get(last)+1);
        }

        return tot;

    }
}