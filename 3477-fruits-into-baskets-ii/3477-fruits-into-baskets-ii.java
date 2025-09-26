class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int count=0;
        for(int i=0;i<fruits.length;i++){
            int flag=0;
            for(int j=0;j<baskets.length;j++){
                if(fruits[i]<=baskets[j]){
                    baskets[j]=-1; // marking used basket
                    flag=-1;
                    break;
                }
            }
            if(flag==0){
                count++;
            }
        }

        return count;
    }
}