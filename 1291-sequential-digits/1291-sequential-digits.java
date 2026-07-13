class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String num = "123456789";
        int len1 = (low+"").length();
        int len2 = (high+"").length();

        List<Integer>list = new ArrayList<>();

        for (int i=len1;i<=len2;i++){
            int windSize=i;
            int start=0;
            int end=i-1;
            
            for (int j=end;j<num.length();j++){
                
                int n = Integer.parseInt(num.substring(start,j+1));
                if (n<=high && n>=low){
                    list.add(n);
                }
                start++;
            }
        }

        return list;
    }
}