class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer>list = new ArrayList<>();

        if(time==0){
            for(int i=0;i<security.length;i++){
                list.add(i);
            }

            return list;
        }

        int pref[] = new int[security.length];
        int suff[] = new int[security.length];

        for(int i=1;i<security.length;i++){
            if(security[i]<=security[i-1]){
                pref[i]=pref[i-1]+1;
            }
        }

        for(int i=security.length-2;i>=0;i--){
            if(security[i]<=security[i+1]){
                suff[i]=suff[i+1]+1;
            }
        }

        for(int i=time;i<security.length-time;i++){
            if(pref[i]>=time && suff[i]>=time){
                list.add(i);
            }
        }
        return list;
    }
}