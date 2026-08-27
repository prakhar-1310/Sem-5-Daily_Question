class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        List<String>list = new ArrayList<>();

        int left=0;
        int ans=Integer.MAX_VALUE;
        int cnt=0;
        for(int right=0;right<s.length();right++){
            if(s.charAt(right)=='1'){
                cnt++;
            }

            while(cnt==k){
                if(ans==(right-left+1)){
                    list.add(s.substring(left,right+1));
                }
                else if(ans>(right-left+1)){
                    ans=right-left+1;
                    list=new ArrayList<>();
                    list.add(s.substring(left,right+1));
                }

                if(s.charAt(left)=='1'){
                    cnt--;
                }

                left++;
            }
        }

        Collections.sort(list);
        if(list.size()==0)return "";
        return list.get(0);
    }
}