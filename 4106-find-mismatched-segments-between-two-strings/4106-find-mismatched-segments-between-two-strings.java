class Solution {
    public List<List<String>> findMismatchedSegments(String s1, String s2) {
        List<List<String>>ans = new ArrayList<>();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        List<String>temp = new ArrayList<>();
        int n = s1.length();

        for(int i=0;i<n;i++){
            char a = s1.charAt(i);
            char b = s2.charAt(i);

            if(a==b){
                if(sb1.length()>0){
                    temp = new ArrayList<>();
                    temp.add(sb1.toString());
                    temp.add(sb2.toString());
                    ans.add(temp);
                    sb1 = new StringBuilder();
                    sb2 = new StringBuilder();
                }
            }
            else{
                sb1.append(a);
                sb2.append(b);
            }
        }

        if(sb1.length()>0){
            temp = new ArrayList<>();
            temp.add(sb1.toString());
            temp.add(sb2.toString());
            ans.add(temp);
        }

        return ans;
    }
}