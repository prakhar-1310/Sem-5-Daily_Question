class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int ans[] = new int[k];

        HashMap<Integer, HashSet<Integer>>map = new HashMap<>();

        for(int i[] : logs){
            if(!map.containsKey(i[0])){
                map.put(i[0], new HashSet<>());
            }

            map.get(i[0]).add(i[1]);
        }

        for(int key : map.keySet()){
            int size = map.get(key).size();
            ans[size-1]++;
        }

        return ans;
    }
}