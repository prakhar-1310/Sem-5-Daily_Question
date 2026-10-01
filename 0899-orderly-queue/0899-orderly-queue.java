class Solution {
    public String orderlyQueue(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        if(k==1){
            List<String>list = new ArrayList<>();
            list.add(s);
            for(int i=0;i<s.length()-1;i++){
                char ch = sb.charAt(0);
                sb = new StringBuilder(sb.substring(1));
                sb.append(ch);
                list.add(sb.toString());
            }

            Collections.sort(list);
            return list.get(0);
            
        }


        int freq[] = new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }

        sb = new StringBuilder();
        for(int i=0;i<26;i++){
            while(freq[i]!=0){
                sb.append((char)('a'+i));
                freq[i]--;
            }
        }
        

        return sb.toString();
    }
}