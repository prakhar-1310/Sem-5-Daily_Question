class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int tot=0;
        int lastG=0;
        int lastP=0;
        int lastM=0;
        
        for(int i=0;i<garbage.length;i++){
            tot+=garbage[i].length();

            if(garbage[i].contains("G")){
                lastG=i;
            }

            if(garbage[i].contains("M")){
                lastM=i;
            }

            if(garbage[i].contains("P")){
                lastP=i;
            }
        }

        int pref[] = new int[travel.length+1];
        pref[0]=0;
        for(int i=1;i<pref.length;i++){
            pref[i]=pref[i-1]+travel[i-1];
        }

        tot+=pref[lastG];
        tot+=pref[lastP];
        tot+=pref[lastM];

        return tot;
    }
}