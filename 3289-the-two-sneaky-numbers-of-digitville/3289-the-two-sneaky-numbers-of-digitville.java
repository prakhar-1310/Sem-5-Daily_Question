class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int arr[] =new int [2];
        List <Integer> list = new ArrayList<>();
        int k=0;
        for (int i :nums){
            if(list.contains(i)){
                arr[k]=i;
                k++;
            }
            else{
                list.add(i);
            }
        }
        return arr;
    }
}