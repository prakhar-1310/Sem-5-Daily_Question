class Solution {
    public int largestInteger(int num) {
        List<Integer>odd = new ArrayList<>();
        List<Integer>even = new ArrayList<>();
        int temp = num;
        while(temp>0){
            int i = temp%10;
            temp/=10;
            if(i%2==0){
                even.add(i);
            }
            else{
                odd.add(i);
            }
        }

        StringBuilder str=new StringBuilder("");
        Collections.sort(even);
        Collections.sort(odd);
        while(num>0){
            int rem = num%10;
            num/=10;
            if(rem%2==0){
                str.append(even.get(0));
                even.remove(0);
            }
            else{
                str.append(odd.get(0));
                odd.remove(0);
            }
        }

        return Integer.parseInt(str.reverse().toString());
    }
}