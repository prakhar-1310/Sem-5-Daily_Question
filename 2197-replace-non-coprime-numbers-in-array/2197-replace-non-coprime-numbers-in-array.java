class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer>list = new ArrayList<>();
        if(nums.length==1){
            list.add(nums[0]);
            return list;
        }
        
        for(int i : nums){
            list.add(i);
            while(list.size()>1){
                int a = list.get(list.size()-1);
                int b = list.get(list.size()-2);
                int g = gcd(a,b);
                if(g>1){
                    list.remove(list.size()-1);
                    list.remove(list.size()-1);
                    long lcm = (1L*a*b)/g;
                    list.add((int)lcm);
                }
                if(g==1){
                    break;
                }
            }
        }
        return list;
    }
    
    private int gcd(int a, int b) {
        if(b==0){
            return a;
        }
        int g = gcd(b, a%b);
        return g;
    }
}