class Solution {
    public int minInsertions(String s) {
        
        int op=0;
        int clo=0;
        int tot=0;
        for(char ch : s.toCharArray()){
            if(ch=='('){
                if(clo!=0){
                    if(clo%2==0){ // means due to less open
                        tot+=clo/2;
                        clo=0;
                        op=0;
                    }
                    else{ // means due to less close and may be less open too
                        tot++; // one more close
                        int opNeeded = (clo+1)/2;
                        if(opNeeded<=op){
                            op-=opNeeded;
                            clo=0;
                        }else{
                            tot+=(opNeeded-op);
                            op=0;
                            clo=0;
                        }
                    }

                }
                op++;
            }
            else if(ch==')'){
                clo++;
            }
            
            if(clo==2 && op>0){
                op--;
                clo=0;
            }
        }

        if(op!=0){ // means close needed
            int cloNeeded = op*2;
            tot+=(cloNeeded-clo);
        }
        else if(clo!=0){
                    if(clo%2==0){ // means due to less open
                        tot+=clo/2;
                        clo=0;
                        op=0;
                    }
                    else{ // means due to less close and may be less open too
                        tot++; // one more close
                        int opNeeded = (clo+1)/2;
                        if(opNeeded<=op){
                            op-=opNeeded;
                            clo=0;
                        }else{
                            tot+=(opNeeded-op);
                            op=0;
                            clo=0;
                        }
                    }

        }

        return tot;
    }
}