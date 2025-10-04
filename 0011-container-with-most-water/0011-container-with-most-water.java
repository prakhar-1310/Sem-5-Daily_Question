class Solution {
    public int maxArea(int[] height) {
        // int ans =0;
        // for (int i=0;i<height.length-1;i++){
        //     for (int j=i+1;j<height.length;j++){
        //         int water = (j-i)*(Math.min(height[i],height[j]));
        //         ans = Math.max(water,ans);
        //     }
        // }
        // return ans;


        int ans =0;
        int left = 0;
        int right= height.length-1;
        while (left<right){
            int water = (right-left)*(Math.min(height[left],height[right]));
            ans = Math.max(water,ans);

            if (height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return ans;
    }
}