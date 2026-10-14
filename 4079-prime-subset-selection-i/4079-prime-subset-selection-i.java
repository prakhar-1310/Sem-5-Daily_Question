class Solution {
    public List<Integer> maxPrimes(int n, int s) {
        int arr[] = new int[n+1];

        for(int i=2;i<=n;i++){
            if(arr[i]==0){
                for(int j=i*2;j<=n;j+=i){
                    arr[j]=1;
                }
            }
        }

        List<Integer>list = new ArrayList<>();
        int sum=0;
        for(int i=2;i<=n;i++){
            if(arr[i]==0 && sum+i<=s){
                list.add(i);
                sum+=i;
            }
            if(sum+i>=s){
                break;
            }
        }

        

        return list;
    }
}