class Solution {
    public String minimizeResult(String exp) {
        int idx=-1;
        for(int i=0;i<exp.length();i++){
            if(exp.charAt(i)=='+'){
                idx=i;
                break;
            }
        }

        int ans = Integer.MAX_VALUE;
        String best="";

        for(int i=0;i<idx;i++){
            for(int j=idx+1;j<exp.length();j++){
                String part1 =exp.substring(0,i);
                String part2 = exp.substring(i,idx);
                String part3 = exp.substring(idx+1,j+1);
                String part4 = exp.substring(j+1,exp.length());

                int p1=0;
                if(part1.length()==0){
                    p1=1;
                }
                else{
                    p1=Integer.parseInt(part1);
                }

                int p4=0;
                if(part4.length()==0){
                    p4=1;
                }
                else{
                    p4=Integer.parseInt(part4);
                }

                int p3=Integer.parseInt(part3);
                int p2=Integer.parseInt(part2);

                if(ans>(p2+p3)*p1*p4){
                    ans=(p2+p3)*p1*p4;
                    best=part1+"("+part2+"+"+part3+")"+part4;
                }
            }
        }

        return best;
    }
}