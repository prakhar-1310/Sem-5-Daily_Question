class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String dir) {
        int arr[][] = new int[dir.length()][3]; // pos, dir, health
        // L=0; R=1
        for(int i=0;i<dir.length();i++){
            arr[i][0]=positions[i];
            if(dir.charAt(i)=='L'){
                arr[i][1]=0;
            }else{
                arr[i][1]=1;
            }
            arr[i][2]=healths[i];
        }

        Arrays.sort(arr,(a,b)->{
            return a[0]-b[0];
        });
        
        Stack<Integer>st = new Stack<>();

        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()][1]==1 && arr[i][1]==0 && arr[i][2]>0){
                if(arr[st.peek()][2]==arr[i][2]){
                    arr[st.peek()][2]=0;
                    arr[i][2]=0;
                    st.pop();
                }
                else if(arr[st.peek()][2]>arr[i][2]){
                    arr[st.peek()][2]--;
                    arr[i][2]=0;
                }
                else{
                    arr[i][2]--;
                    arr[st.peek()][2]=0;
                    st.pop();
                }
            }

            if(arr[i][2]>0){
                st.push(i);
            }
        }
        
        List<Integer>ans = new ArrayList<>();
        
        HashMap<Integer,Integer>map = new HashMap<>();

        for(int i=0;i<positions.length;i++){
            map.put(positions[i],i);
        }

        int a[] = new int[arr.length];

        for(int i[] : arr){
            int h = i[2];
            int p = i[0];
            a[map.get(p)]=h;
        }

        for(int i: a){
            if(i>0){
                ans.add(i);
            }
        }

        return ans;

    } 
}