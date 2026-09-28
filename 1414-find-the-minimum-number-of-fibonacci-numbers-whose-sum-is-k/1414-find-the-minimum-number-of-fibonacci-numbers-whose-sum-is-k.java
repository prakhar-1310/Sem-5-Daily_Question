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

        int cnt=1;
        k-=list.get(list.size()-1);

        while(k!=0){
            int curr=0;
            for(int i : list){
                if(i>k){
                    k-=curr;
                    cnt++;
                    break;
                }
                curr=i;
            }
        }

        return cnt;
    }
}