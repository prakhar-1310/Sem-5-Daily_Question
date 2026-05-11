class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer>ll = new ArrayList<>();
        for(int i : nums){
            String k = i+"";
            for(char ch : k.toCharArray()){
                ll.add(ch-'0');
            }
        }

        int ans[] = new int[ll.size()];
        int k=0;
        for(int i : ll){
            ans[k++]=i;
        }

        return ans;
    }
}