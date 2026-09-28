class Solution {
    public int countSpecialIntegers(int[] nums) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }

        int ans = 0;

        for (List<Integer> list : map.values()) {

            if (list.size() < 3) {
                continue;
            }

            int gap = list.get(1) - list.get(0);
            boolean valid = true;

            for (int i = 2; i < list.size(); i++) {
                if (list.get(i) - list.get(i - 1) != gap) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                ans++;
            }
        }

        return ans;
    }
}