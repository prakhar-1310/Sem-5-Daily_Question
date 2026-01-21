class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int xor =0;
		for(int v : derived) {
			xor^=v;
		}
		
		return xor==0;
    }
}