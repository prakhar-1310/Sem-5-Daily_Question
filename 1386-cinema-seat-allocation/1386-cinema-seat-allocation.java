class Solution {
    public int maxNumberOfFamilies(int n, int[][] res) {
        int tot=0;
        Arrays.sort(res, (a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });

        int prev=1;
        for(int i=0;i<res.length;){
            int r = res[i][0];
            int c = res[i][1];
            tot+=2*(r-prev);
            prev=r+1;

            if(c>9){
                tot+=2;
            }
            else if(c>5){
                tot+=1;
            }

            i++;
            
            int prevC=c;
            while(i<res.length && res[i][0]==r){
                int col = res[i][1];
                if(res[i][1]-prevC-1>=8){
                    tot+=2;
                }
                else if((col>5 && prevC<2) || (col>7 && prevC<4) || (col>9 && prevC<6)){
                    
                        tot+=1;
                    
                    
                }
                prevC=res[i][1];
                i++;
            }

            if(10-prevC-1>=8){
                tot+=2;
            }
            else if(10-prevC-1>=4){
                tot+=1;
            }

            System.out.println(tot);
        }

        tot+=(2*(n-prev+1));

        return tot;
    }
}