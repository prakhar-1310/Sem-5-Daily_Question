class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int tot=0;
        for(int j=0;j<3;j++){
            String tar="";
            if(j==0){
                tar="G";
            }
            else if(j==1)tar="P";
            else tar="M";

            int trav=0;
            int perHouse=0;
        
            for(int i=0;i<garbage.length;i++){
                String s = garbage[i];

                for(char ch : s.toCharArray()){
                    if((ch+"").equals(tar)){
                        perHouse++;
                    }
                }

                if(perHouse!=0){
                    tot+=perHouse;
                    tot+=trav;
                    trav=0;
                    perHouse=0;
                    //System.out.println(tot);
                }

                if(i!=garbage.length-1){
                    trav+=travel[i];
                }
            }
        }

        return tot;
    }
}