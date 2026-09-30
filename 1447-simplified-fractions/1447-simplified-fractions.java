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

            if(isSimplified(num, deno)){
                String tem = num+"/"+deno;
                ans.add(tem);
            }
            num++;
        }

        return ans;
    }

    public boolean isSimplified(int num, int deno){
        for(int i=2; i<deno;i++){
            if(num%i==0 && deno%i==0){
                return false;
            }
        }

        return true;
    }
}