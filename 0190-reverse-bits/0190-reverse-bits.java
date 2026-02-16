class Solution {
    public int reverseBits(int n) {
        String s = String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0');
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return (int) Long.parseLong(sb.toString(), 2); // Use Long to avoid overflow
    }
}