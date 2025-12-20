class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs[0].length();
        String arr[] = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = "";
        }
        for(int i=0;i<strs.length;i++){
            String str = strs[i];
            for(int j=0;j<n;j++){
                arr[j]+=str.charAt(j);
            }
        }

        int count=0;
        for(String i : arr){
            for(int j=1;j<i.length();j++){
                if(i.charAt(j-1)>i.charAt(j)){
                    count++;
                    break;
                }
            }
        }

        return count;
    }
}