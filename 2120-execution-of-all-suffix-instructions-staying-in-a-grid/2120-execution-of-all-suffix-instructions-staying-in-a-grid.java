class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int ans[] = new int[s.length()];
        int x = startPos[0];
        int y = startPos[1];
        for(int i=0;i<s.length();i++){
            int an=0;
            if(s.charAt(i)=='R'){
                an=helper(i+1, s, x, y+1, n);
            }
            else if(s.charAt(i)=='L'){
                an=helper(i+1, s, x, y-1, n);
            }
            else if(s.charAt(i)=='U'){
                an=helper(i+1, s, x-1, y, n);
            }
            else if(s.charAt(i)=='D'){
                an=helper(i+1, s, x+1, y, n);
            }
            ans[i]=an;
        }
        return ans;
    }

    public int helper(int ind, String s, int x, int y, int n){
        if(x<0 || x>=n || y<0 || y>=n){
            return 0;
        }

        if(ind==s.length())return 1;

        int ans=1;
        if(s.charAt(ind)=='R'){
            ans+=helper(ind+1, s, x, y+1, n);
        }
        else if(s.charAt(ind)=='L'){
            ans+=helper(ind+1, s, x, y-1, n);
        }
        else if(s.charAt(ind)=='U'){
            ans+=helper(ind+1, s, x-1, y, n);
        }
        else if(s.charAt(ind)=='D'){
            ans+=helper(ind+1, s, x+1, y, n);
        }

        return ans;
    }
}