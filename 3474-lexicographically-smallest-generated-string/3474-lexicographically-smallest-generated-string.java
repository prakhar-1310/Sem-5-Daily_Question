class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        char arr[] = new char[n+m-1];
        boolean lock[] = new boolean[n+m-1];
        Arrays.fill(arr,'*');

        for(int i=0;i<n;i++){
            char ch = str1.charAt(i);
            if(ch=='T'){
                for(int k=i;k<i+m;k++){
                    if(arr[k]!='*' && arr[k]!=str2.charAt(k-i)) return "";
                    arr[k]=str2.charAt(k-i);
                    lock[k]=true;
                }
            }
        }

        for(int i=0;i<n+m-1;i++){
            if(arr[i]=='*'){
                arr[i]='a';
            }
        }

        for(int i=0;i<n;i++){
            if(str1.charAt(i)=='F'){
                boolean match = true;

                for(int k=0;k<m;k++){
                    if(arr[i+k]!=str2.charAt(k)){
                        match = false;
                        break;
                    }
                }

                if(match){
                    boolean done=false;
                    for(int k=m-1;k>=0;k--){
                        if(lock[i+k])continue;
                        char ori = arr[i+k];
                        arr[i+k]++;
                        done=true;
                        break;
                    }

                    if(!done){
                        return "";
                    }

                }
            }
        }

        return new String(arr);
    }
}