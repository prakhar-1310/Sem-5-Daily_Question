class Solution {
    public int eatenApples(int[] apples, int[] days) {
        int arr[][] = new int[apples.length][3]; // idx, apples, days
        int max=0;
        for(int i=0;i<apples.length;i++){
            if(apples[i]==0)continue;
            arr[i][0]=i;
            arr[i][1]=apples[i];
            arr[i][2]=days[i]+i-1;
            max=Math.max(max, days[i]);
        }

        Arrays.sort(arr, (a,b)->{
            if(a[2]==b[2]){
                return a[0]-b[0];
            }
            return a[2]-b[2];
        });


        int tem[] = new int[max+apples.length];
        System.out.println(tem.length);

        Arrays.fill(tem, -1);

        for(int i[] : arr){
            int st = i[0];
            int ed = i[2];
            int curr = i[1];
            for(int j=st;j<=ed && curr>0;j++){
                if(tem[j]==-1){
                    tem[j]=curr-1;
                    curr--;
                }
                else{
                    tem[j]+=curr;
                }
            }
        }

        int ans=0;

        for(int i : tem){
            if(i!=-1){
                ans++;
            }
        }

        return ans;
    }
}