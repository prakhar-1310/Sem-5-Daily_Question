class Solution {
    public double angleClock(int hour, int minutes) {
        double h = ((360.0/12)*hour) + (((360.0/12)/60)*minutes);
        double m = (360.0/60)*minutes;
        double abs = Math.abs(h-m);
        return Math.min(360-abs,abs);
    }
}