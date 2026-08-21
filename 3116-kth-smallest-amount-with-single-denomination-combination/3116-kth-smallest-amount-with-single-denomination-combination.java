class Solution {
    public long findKthSmallest(int[] coins, int k) {
        int min = coins[0];
        for(int i : coins){
            min = Math.min(min,i);
        }
        long left = 1;
        long right = 1L*k*min;
        long ans=-1;

        while(left<=right){
            long mid = left + (right-left)/2;

            if(check(coins,k,mid)){
                ans = mid;
                right = mid-1;
            }
            else{
                left=mid+1;
            }
        }

        return ans;
    }

    public boolean check(int arr[], int k, long val){
        long count = 0;
        int m = arr.length;
        for(int mask=1; mask<(1<<m);mask++){
            int bit=0;
            long lcm=1;
            for(int i=0;i<m;i++){
                if((mask&(1<<i))!=0){
                    bit++;
                    lcm = lcm(lcm,arr[i]);
                }
            }

            if(bit%2==0){
                count-=val/lcm;
            }
            else{
                count+=val/lcm;
            }
        }

        return count>=k;
    }

    public long lcm(long a, long b){
        return a*b / gcd(a,b);

    }

    public long gcd(long a, long b){
        if(b==0){
            return a;
        }

        return gcd(b, a%b);
    }
    
}