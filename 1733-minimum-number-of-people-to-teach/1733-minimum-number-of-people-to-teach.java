class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        HashMap<Integer,List<Integer>>map = new HashMap<>();
        int j=1;
        for(int arr[] : languages){
            List<Integer>list = new ArrayList<>();
            for(int num : arr){
                list.add(num);
            }
            map.put(j,list);
            j++;
        } 
        HashSet<Integer>person= new HashSet<>();
        for(int arr[] : friendships){
            int u = arr[0];
            int v = arr[1];
            int flag=0;
            for(int i : map.get(u)){
                if(map.get(v).contains(i)){
                    flag =1;
                }
            }
            
            if(flag==0){
                person.add(u);
                person.add(v);
            }  
        }

        int ans=Integer.MAX_VALUE;

        for(int lang=1;lang<=n;lang++){
            int count=0;
            for(int i:person){
                if(!map.get(i).contains(lang)){
                    count++;
                }
            }
            ans = Math.min(ans,count);
        }

        return ans;
    }
}