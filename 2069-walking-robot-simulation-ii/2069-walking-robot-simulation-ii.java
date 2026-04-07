class Robot {
    int w,h;
    int x,y;
    int dir;
    int peri;

    int direc[][] = {{1,0},
    {0,1},
    {-1,0},
    {0,-1}};

    String dirNames[]={"East", "North", "West", "South"};

    public Robot(int width, int height) {
        this.w = width;
        this.h = height;
        this.x=0;
        this.y=0;
        this.dir=0;
        this.peri = 2*(w+h-2);
    }
    
    public void step(int num) {
        if(this.peri==0)return;

        num%=peri;

        if(num==0)num=peri;

        while(num-->0){
            int nx = x+direc[dir][0];
            int ny = y+direc[dir][1];

            if(nx<0 || nx>=w || ny<0 || ny>=h){
                dir=(dir+1)%4;
                nx=x+direc[dir][0];
                ny=y+direc[dir][1];
            }

            x=nx;
            y=ny;
        }
    }
    
    public int[] getPos() {
        return new int[]{x,y};
    }
    
    public String getDir() {
        return dirNames[dir];
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */