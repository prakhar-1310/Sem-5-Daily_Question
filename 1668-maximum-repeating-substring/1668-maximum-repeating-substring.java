class Solution {
    public int maxRepeating(String sequence, String word) {
        int count=0;
        String tar = word;

        while(sequence.contains(tar)){
            count++;
            tar = tar+word;
        }

        return count;
    }
}