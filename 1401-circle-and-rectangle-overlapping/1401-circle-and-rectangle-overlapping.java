class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int closestX = Math.max(x1, Math.min(x2, xCenter));
        int closestY = Math.max(y1, Math.min(y2, yCenter));

        int dx = xCenter - closestX;
        int dy = yCenter - closestY;

        return (dx*dx) + (dy*dy) <= radius*radius;
    }
}