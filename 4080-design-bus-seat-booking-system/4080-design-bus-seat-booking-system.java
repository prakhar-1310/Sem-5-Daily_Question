class BusBooking {
    int n;
    int book[][];
    int time;
    int seatBooked;

    public BusBooking(int n) {
        this.n = n;
        book = new int[n][4];
        this.time=0;
        this.seatBooked=0;

    }
    
    public void toggle(String seat) {
        int col = seat.charAt(0) - 'A';
        int row = Integer.parseInt(seat.substring(1));
        if(book[row-1][col]!=0){
            time-=book[row-1][col];
            book[row-1][col]=0;
            seatBooked--;
        }
        else{
            seatBooked++;
            
            book[row-1][col]=1;
            time++;
            
            
            if((col==0 && book[row-1][1]!=0) || (col==3 && book[row-1][2]!=0)){
                book[row-1][col]+=2;
                time+=2;
            }
        }
    }
    
    public int getTotalTime() {
        return time;
    }
    
    public int getMinTime() {
        return seatBooked;
    }
}

/**
 * Your BusBooking object will be instantiated and called as such:
 * BusBooking obj = new BusBooking(n);
 * obj.toggle(seat);
 * int param_2 = obj.getTotalTime();
 * int param_3 = obj.getMinTime();
 */