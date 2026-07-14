class Solution {
    static String arr[] = new String[30];
    public String countAndSay(int n) {
        if(arr[n-1]!=null){
            return arr[n-1];
        }
        arr[0]="1";
        for(int i=1;i<30;i++){
            String s = arr[i-1];
            StringBuilder sb = new StringBuilder();
            int j=0;
            while(j<s.length()){
                int cnt=0;
                char ch = s.charAt(j);
                while(j<s.length() && s.charAt(j)==ch){
                    cnt++;
                    j++;
                }
                
                sb.append(cnt);
                sb.append(s.charAt(j-1));
            }
            arr[i]=sb.toString();
        }
        return arr[n-1];
    }
}