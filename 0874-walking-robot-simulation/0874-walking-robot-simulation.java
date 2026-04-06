class Solution {
    public int robotSim(int[] commands, int[][] obs) {
        int dis=0;
        int x=0;
        int y=0;
        char dir = 'n';
        int max=0;
        HashSet<String>set = new HashSet<>();
        for(int i[] : obs){
            set.add(i[0]+","+i[1]);
        }
        for(int i=0; i<commands.length;i++){
            int st = commands[i];
            if(st==-2){
                if(dir=='n'){
                    dir='w';
                }
                else if(dir=='w'){
                    dir='s';
                }
                else if(dir=='s'){
                    dir='e';
                }
                else if(dir=='e'){
                    dir='n';
                }
            }
            else if(st==-1){
                if(dir=='n'){
                    dir='e';
                }
                else if(dir=='w'){
                    dir='n';
                }
                else if(dir=='s'){
                    dir='w';
                }
                else if(dir=='e'){
                    dir='s';
                }
            }

            else{
                if(dir=='n' || dir=='s'){
                    y = helpery(x, y, set, st, dir);
                    max = Math.max(max, x*x + y*y);
                }
                else{
                    x = helperx(x, y, set, st, dir);
                    max = Math.max(max, x*x + y*y);
                }
            }
        }

        return max;
    }

    public int helperx(int x, int y, HashSet<String>set, int st, char dir){
        if(dir=='w'){
            for(int i=x-1;i>=x-st;i--){
                if(set.contains(i+","+y)){
                    return i+1;
                }
            }
            return x-st;
        }
        for(int i=x+1;i<=x+st;i++){
            if(set.contains(i+","+y)){
                return i-1;
            }
        }
        return x+st;
    }

    public int helpery(int x, int y, HashSet<String>set, int st, char dir){
        if(dir=='s'){
            for(int i=y-1;i>=y-st;i--){
                if(set.contains(x+","+i)){
                    return i+1;
                }
            }
            return y-st;
        }
        for(int i=y+1;i<=y+st;i++){
            if(set.contains(x+","+i)){
                return i-1;
            }
        }
        return y+st;
    }
}