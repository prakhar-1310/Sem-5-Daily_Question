class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int freq[] = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }

        char mid='#';
        int cnt=0;
        for(int i=0;i<26;i++){
            if(freq[i]%2!=0){
                mid=(char)(i+'a');
                cnt++;
            }
            freq[i]= freq[i]/2;
        }
        if(cnt>1)return "";
        System.out.println(mid);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<target.length()/2;i++){
            char ch = target.charAt(i);
            if(freq[ch-'a']>0){
                sb.append(ch);
                freq[ch-'a']--;
            }

            else{
                for(int j=0;j<26;j++){

                    if((char)('a'+j)>ch && freq[j]>0){
                        
                        sb.append((char)('a'+j));
                        freq[j]--;

                        for(int k=0;k<26;k++){
                            while(freq[k]>0){
                                sb.append((char)('a'+k));
                                freq[k]--;
                            }
                        }

                        StringBuilder ans = new StringBuilder();
                        ans.append(sb);
                        if(mid!='#')ans.append(mid);
                        ans.append(sb.reverse());

                        return ans.toString();
                    }
                }
                String ans = helper(i-1,s,target,freq,sb);
                if(ans.equals("")) return "";
                sb = new StringBuilder(ans);
                StringBuilder ans2 = new StringBuilder(ans);
                if(mid!='#') ans2.append(mid);
                ans2.append(sb.reverse());
                return ans2.toString();
            }
        }

        StringBuilder ans = new StringBuilder(sb);
        if(mid!='#') ans.append(mid);
        ans.append(sb.reverse());
        if(ans.toString().compareTo(target)>0)return ans.toString();

        String an = helper(s.length()/2-1,s,target,freq, sb.reverse());
        if(an.equals("")) return "";
        sb = new StringBuilder(an);
        StringBuilder ans2 = new StringBuilder(an);
        if(mid!='#') ans2.append(mid);
        ans2.append(sb.reverse());
        return ans2.toString();

    }

    public String helper(int idx, String s, String tar, int freq[], StringBuilder sb){
        for(int i=idx;i>=0;i--){
            char ch = tar.charAt(i);
            for(int j=0;j<26;j++){
                char c = (char)('a'+j);
                if(c>ch && freq[j]>0){
                    String n = sb.substring(0,i)+c;
                    sb = new StringBuilder(n);
                    freq[ch-'a']++;
                    freq[c-'a']--;
                    for(int k=0;k<26;k++){
                        while(freq[k]>0){
                            sb.append((char)('a'+k));
                            freq[k]--;
                        }
                    }
                    return sb.toString();
                }
            }
            freq[ch-'a']++;
        }

        return "";

    }
}