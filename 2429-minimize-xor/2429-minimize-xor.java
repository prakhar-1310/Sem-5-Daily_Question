class Solution {
    public int minimizeXor(int num1, int num2) {
        int setbit=0;
		while(num2>0) {
			setbit++;
			num2= (num2&(num2-1));
		}
		
		
		int x=0;
		for(int i=30;i>=0;i--) {
			int mask = (1<<i);
			
			if((num1&mask)!=0) {
				x|=mask;
				setbit--;
				
				if(setbit==0) {
					return x;
				}
			}
		}
		
		for(int i=0;i<31;i++) {
			int mask = (1<<i);
			
			if((num1&mask)==0) {
				x|=mask;
				setbit--;
				
				if(setbit==0) {
					return x;
				}
			}
		}
		
		return -1;
    }
}