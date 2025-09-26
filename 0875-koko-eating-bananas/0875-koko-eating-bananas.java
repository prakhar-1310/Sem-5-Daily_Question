class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int low =1;
        int high = piles[piles.length-1];
        int ans = high;
        while (low<=high){
            int mid =low + (high-low)/2;
            if (isitpossible(piles,h,mid)){
                ans = mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static boolean isitpossible(int []piles, int h , int mid){
        int time=0;
        int i=0;
        while (i<piles.length){
            if (piles[i]<=mid){
                time++;
                i++;
            }
            else{
                int j=1;
                time += (int)Math.ceil((double)piles[i] / mid);
                i++;
            }
            if (time>h){
                return false;
            }
        }
        return true;
    }
}