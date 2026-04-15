class Solution {
    public int closetTarget(String[] words, String target, int startIndex) {
        int mindist=Integer.MAX_VALUE;
        int check=0;
        for (int i =0;i<words.length;i++){
            if (words[i].equals(target)){
                int forwardDist = Math.abs(i-startIndex);
                int backDist= words.length-forwardDist;
                mindist = Math.min(mindist,Math.min(forwardDist,backDist));
                check=1;
            }
        }
        if (check==0){
            return -1;
        }
        return mindist;
    }
}