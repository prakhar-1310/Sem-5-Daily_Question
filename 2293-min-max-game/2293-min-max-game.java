class Solution {
    public int minMaxGame(int[] nums) {
        List<Integer>list = new ArrayList<>();
        for(int i : nums){
            list.add(i);
        }
        List<Integer>temp= new ArrayList<>();
        while(list.size()>1){
            temp = new ArrayList<>();
            int min=1;
            for(int i=0;i<list.size();i+=2){
                int a = list.get(i);
                int b = list.get(i+1);
                if(min==1){
                    temp.add(Math.min(a,b));
                    min=0;
                }
                else{
                    temp.add(Math.max(a,b));
                    min=1;
                }
            }
            list = temp;
        }

        return list.get(0);
    }
}