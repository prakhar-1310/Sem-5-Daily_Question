class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int len = strs[0].length();
        int del=0;
        for(int i=0;i<len;i++){
            boolean flag = true;
            for(int j=1;j<n;j++){
                if(strs[j-1].charAt(i)==strs[j].charAt(i)){
                    flag=false;
                }
                else if(strs[j-1].charAt(i)>strs[j].charAt(i)){
                    flag=false;
                    del++;
                    break;
                }
            }
            if(flag==true){
                break;
            }
        }

        return del;
    }
}