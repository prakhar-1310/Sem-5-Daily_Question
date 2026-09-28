class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<int []> list = new ArrayList<>();
        for(int i[] : restaurants){
            int price = i[3];
            int dis = i[4];
            int vegan = i[2];

            if(veganFriendly==1 && vegan!=1)continue;

            if(price<=maxPrice && dis<=maxDistance){
                list.add(i);
            }
        }

        Collections.sort(list, (a,b)->{
            if(a[1]==b[1]){
                return b[0]-a[0];
            }
            return b[1]-a[1];
        });

        List<Integer>ans = new ArrayList<>();

        for(int i[] : list){
            ans.add(i[0]);
        }

        return ans;
    }
}