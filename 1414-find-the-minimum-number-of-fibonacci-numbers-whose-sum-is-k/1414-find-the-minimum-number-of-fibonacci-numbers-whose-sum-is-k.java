class Solution {
    public int findMinFibonacciNumbers(int k) {
        List<Integer>list = new ArrayList<>();
        int a = 1;
        int b = 1;
        list.add(1);
        list.add(1);
        while(true){
            int c = a+b;
            if(c>k){
                break;
            }
            list.add(c);
            a=b;
            b=c;
        }
        int cnt=0;

        for(int i=list.size()-1;i>=0;i--){
            if(k>=list.get(i)){
                k-=list.get(i);
                cnt++;
                if(k==0){
                    break;
                }
            }
        }
        return cnt;
    }
}