class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int ans = Integer.MAX_VALUE;
        for(int i=1;i<=6;i++){
            int cnt=0;
            for(int j=0;j<tops.length;j++){
                if(tops[j]==i){
                    
                }
                else if(bottoms[j]==i){
                    cnt++;
                }
                else{
                    break;
                }

                if(j==tops.length-1){
                    ans=Math.min(ans,cnt);
                }
            }
            cnt=0;
            for(int j=0;j<tops.length;j++){
                if(bottoms[j]==i){
                    
                }
                else if(tops[j]==i){
                    cnt++;
                }
                else{
                    break;
                }

                if(j==tops.length-1){
                    ans=Math.min(ans,cnt);
                }
            }
        }

        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
}