class Solution {
    public int maxValidSplits(int[] nums) {
        int n = nums.length;
        int pref[] = new int[n];
        pref[0]=nums[0];
        for(int i=1;i<n;i++){
            pref[i] = gcd(pref[i-1], nums[i]);
        }

        int suff[] = new int[n];
        suff[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            suff[i]=gcd(suff[i+1], nums[i]);
        }

        int ans=0;
        // removing zero element
        for(int i=0;i<n-1;i++){
            if(pref[i]==suff[i+1]){
                ans++;
            }
        }


        // now removing 1 element
        for(int i=0;i<n;i++){
            // ith ele is removed
            List<Integer>list = new ArrayList<>();
            for(int j =0;j<n;j++){
                if(i!=j)list.add(nums[j]);
            }
            pref = new int[n-1];
            suff = new int[n-1];
            pref[0]=list.get(0);
            for(int j=1;j<n-1;j++){
                pref[j] = gcd(pref[j-1], list.get(j));
            }

            suff[n-2]=list.get(n-2);
            for(int j=n-3;j>=0;j--){
                suff[j]=gcd(suff[j+1], list.get(j));
            }

            int cnt=0;
            for(int j=0;j<n-2;j++){
                if(pref[j]==suff[j+1]){
                    cnt++;
                }
            }
            ans = Math.max(ans,cnt);
        }

        return ans;
    }

    public int gcd(int a, int b){
        if(b==0){
            return a;
        }

        return gcd(b, a%b);
    }
}