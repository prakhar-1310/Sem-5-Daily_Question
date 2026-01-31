class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        // for (int i =0;i<letters.length;i++){
        //     if (letters[i]>target){
        //         return letters[i];
        //     }
        // }
        // return letters[0];


        int low =0;
        int high = letters.length-1;
        char ans = letters[0];
        while (low<=high){
            int mid =low + (high-low)/2;
            if (letters[mid]>target){
                ans = letters[mid];
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}