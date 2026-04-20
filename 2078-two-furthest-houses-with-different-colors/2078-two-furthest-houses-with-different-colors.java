class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int first=0;
        for(int i=n-1;i>0;i--){
            if(colors[0]!=colors[i]){
                first=i;
                break;
            }
        }

        int second=0;
        for(int i=0;i<n-1;i++){
            if(colors[n-1]!=colors[i]){
                second=n-1-i;
                break;
            }
        }

        return Math.max(first,second);
    }
}