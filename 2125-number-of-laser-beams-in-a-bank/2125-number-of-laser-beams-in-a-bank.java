class Solution {
    public int numberOfBeams(String[] bank) {
        List<Integer> list = new ArrayList<>();
        for (String i : bank){
            int count=0;
            for (char j : i.toCharArray()){
                if(j=='1'){
                    count++;
                }
            }
            if(count!=0){
                list.add(count);
            }
        }

        int ans=0;
        for (int i=0;i<list.size()-1;i++){
            ans+=list.get(i)*list.get(i+1);
        }

        return ans;
    }
}