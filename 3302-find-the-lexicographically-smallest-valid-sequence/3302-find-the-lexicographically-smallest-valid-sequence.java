class Solution {
    public int[] validSequence(String word1, String word2) {
        int matched[] = new int[word1.length()];
        int i=word1.length()-1;
        int j = word2.length()-1;
        int m=0;
        while(i>=0 && j>=0){
            if(word1.charAt(i)==word2.charAt(j)){
                m++;
                matched[i]=m;
                i--;
                j--;
            }
            else{
                matched[i]=m;
                i--;
            }
        }
        while(i>=0){
            matched[i]=m;
            i--;
        }


        List<Integer>ans = new ArrayList<>();
        i=0;
        j=0;
        int mis=0;
        while(i<word1.length() && j<word2.length()){
            if(word1.charAt(i)==word2.charAt(j)){
                ans.add(i);
                i++;
                j++;
            }
            else{
                if(i+1<word1.length() && mis==0 && matched[i+1]>=(word2.length()-j-1)){
                    mis=1;
                    ans.add(i);
                    i++;
                    j++;
                }
                else{
                    i++;
                }
            }
        }

        if (ans.size()!=word2.length())return new int[0];

        int arr[] = new int[ans.size()];
        for(int k=0;k<ans.size();k++){
            arr[k]=ans.get(k);
        }

        return arr;
    }

    
}