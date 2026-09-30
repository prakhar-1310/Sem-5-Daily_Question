class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String>ans = new ArrayList<>();

        int num=1;
        int deno=2;
        while(true){
            if(num==deno){
                deno++;
                num=1;
            }
            if(deno>n)break;

            if(gcd(num, deno)==1){
                String tem = num+"/"+deno;
                ans.add(tem);
            }
            num++;
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