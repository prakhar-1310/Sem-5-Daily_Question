class Solution {
    public boolean judgeCircle(String moves) {
        int x=0;
        int y=0;
        for (int i = 0;i<moves.length();i++){
            char ch = moves.charAt(i);
            if (ch=='U'){
                y+=1;
            }
            else if (ch=='D'){
                    y-=1;
            }
            else if (ch=='L'){
                    x-=1;
            }
            else if (ch=='R'){
                x+=1;
            }
        }
        if (x==0 && y==0){
            return true;
        }
        return false;
    }
}