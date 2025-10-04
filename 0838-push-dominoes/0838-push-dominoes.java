class Solution {
    public String pushDominoes(String dominoes) {
        int nearestRightPush[] = new int [dominoes.length()];//left to right
        int nearestLeftPush[] = new int [dominoes.length()]; //right to left

        for(int i=0;i<dominoes.length();i++){
            char ch =dominoes.charAt(i);
            if(ch=='L'){
                nearestRightPush[i]=-1;
            }
            else{
                if(i==0){
                    if(ch=='R'){
                        nearestRightPush[i]=i;
                    }
                    else{
                        nearestRightPush[i]=-1;
                    }   
                }
                else{
                    if(ch=='R'){
                        nearestRightPush[i]=i;
                    }
                    else{
                        nearestRightPush[i]=nearestRightPush[i-1];
                    }
                }
            }
        }

        for(int i=dominoes.length()-1;i>=0;i--){
            char ch =dominoes.charAt(i);
            if(ch=='R'){
                nearestLeftPush[i]=-1;
            }
            else{
                if(i==dominoes.length()-1){
                    if(ch=='L'){
                        nearestLeftPush[i]=i;
                    }
                    else{
                        nearestLeftPush[i]=-1;
                    }   
                }
                else{
                    if(ch=='L'){
                        nearestLeftPush[i]=i;
                    }
                    else{
                        nearestLeftPush[i]=nearestLeftPush[i+1];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<dominoes.length();i++){
            if(nearestRightPush[i]==-1 && nearestLeftPush[i]==-1){ // means no effect
                sb.append('.'); 
            }
            else if(nearestRightPush[i]==-1){ // no effect of right push
                sb.append('L');
            }
            else if (nearestLeftPush[i]==-1){ // no effect of left push
                sb.append('R');
            }
            else{
                int distfromleft = Math.abs(i-nearestRightPush[i]);// pushing right
                int distfromright = Math.abs(i-nearestLeftPush[i]);//pushing left

                if(distfromleft<distfromright){ // left push distance is more
                    sb.append('R');
                }
                else if(distfromleft>distfromright){ // right push distance is more
                    sb.append('L');
                }
                else{ // have equal distance from left push and right push
                    sb.append('.');
                }
            }
        }
        return sb.toString();
    }
}