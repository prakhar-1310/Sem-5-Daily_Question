class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int fir[] = new int[26];
        int las[] = new int[26];
        Arrays.fill(fir, n);
        Arrays.fill(las, -1);
    
        for(int i=0;i<n;i++){
            fir[s.charAt(i)-'a']=Math.min(fir[s.charAt(i)-'a'], i);
            las[s.charAt(i)-'a']=i;
        }

        List<int []>interval = new ArrayList<>();
        
        for(int i=0;i<26;i++){
            if(las[i]==-1)continue;

            int start = fir[i];
            int end = las[i];

            boolean valid=true;

            for(int j=start;j<=end;j++){
                char ch = s.charAt(j);
                if(fir[ch-'a']<start){
                    valid=false;
                    break;
                }
                end = Math.max(end, las[ch-'a']);
            }

            if(valid){
                interval.add(new int[]{start, end});
            }
        }

        Collections.sort(interval, (a,b)->{
            return a[1]-b[1];
        });

        List<String>ans = new ArrayList<>();

        int prev=-1;

        for(int i[] : interval){
            int left = i[0];
            int right = i[1];

            if(left>prev){
                ans.add(s.substring(left, right+1));
                prev=right;
            }
        }

        return ans;
    }
    
}