class Solution {
    public int wateringPlants(int[] plants, int cap) {
        int tem = cap;
        int n = plants.length;
        int tot=1;
        cap-=plants[0];
        for(int i=1;i<n;i++){
            if(plants[i]<=cap){
                tot++;
                cap-=plants[i];
            }
            else{
                tot+=(i*2)+1;
                cap=tem-plants[i];
            }
        }

        return tot;

    }
}