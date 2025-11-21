class Solution {
    public int countPalindromicSubsequence(String s) {
        int first[] = new int[26];
        int last[] = new int[26];
        Arrays.fill(first,-1);
        Arrays.fill(last,-1);
        for(int i=0;i<s.length();i++){
            int ind = s.charAt(i)-'a';
            if(first[ind]==-1){
                first[ind]=i;
                last[ind]=i;
            }
            else{
                last[ind]=i;
            }
        }

        int count=0;
        for(int i=0;i<26;i++){
            if(first[i]!=-1 && first[i]<last[i]){
                boolean uni[] = new boolean[26];
                for(int j=first[i]+1;j<last[i];j++){
                    if(!uni[s.charAt(j)-'a']){
                        uni[s.charAt(j)-'a']=true;
                        count++;
                    }
                }
            }
        }

        return count;
    }
}