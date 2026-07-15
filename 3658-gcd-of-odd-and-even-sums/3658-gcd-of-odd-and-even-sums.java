class Solution {
    public int gcdOfOddEvenSums(int n) {
        int odSum=0;
        int cnt=0;
        int i=1;
        while(cnt<n){
            odSum+=i;
            i+=2;
            cnt++;
        }

        int evSum=0;
        cnt=0;
        i=2;
        while(cnt<n){
            evSum+=i;
            cnt++;
            i+=2;
        }

        System.out.println(evSum+" "+odSum);

        return gcd(evSum, odSum);
        
    }

    public int gcd(int a, int b){
        if(b==0){
            return a;
        }

        return gcd(b, a%b);

    }
}