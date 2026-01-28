class Solution {
    public int countTexts(String pressedKeys) {
        int mod=(int)Math.pow(10,9)+7;
        int len=pressedKeys.length();
       int[] dp=new int[len+1];
        dp[0]=1;
        for(int i=1;i<len+1;i++){
            char ch=pressedKeys.charAt(i-1);
        
             dp[i]=dp[i-1];
            if(i-2>=0 && pressedKeys.charAt(i-2)==ch ){
                dp[i]=(dp[i]+dp[i-2])%mod;
                
                if(i-3>=0 &&  pressedKeys.charAt(i-3)==ch ){    
                    dp[i]=(dp[i]+dp[i-3])%mod;
                    if((i-4>=0 && pressedKeys.charAt(i-4)==ch)&& (ch=='7' || ch=='9')  ){
                    dp[i]=(dp[i]+dp[i-4])%mod;
                    }
                }
            }
            
            
           // System.out.print(dp[i]+" ");
        }
         
        return dp[len];
    }
}