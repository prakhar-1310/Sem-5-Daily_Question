class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int nega=0;
        int pos=0;

        for(String i : operations){
            if(i.contains("-")){
                nega++;
            }
            else{
                pos++;
            }
        }

        return pos-nega;
    }
}