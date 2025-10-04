class Solution {
    public String pushDominoes(String dominoes) {
        int right[] = new int [dominoes.length()];//left to right
        int left[] = new int [dominoes.length()]; //right to left

        for(int i=0;i<dominoes.length();i++){
            char ch =dominoes.charAt(i);
            if(ch=='L'){
                right[i]=-1;
            }
            else{
                if(i==0){
                    if(ch=='R'){
                        right[i]=i;
                    }
                    else{
                        right[i]=-1;
                    }   
                }
                else{
                    if(ch=='R'){
                        right[i]=i;
                    }
                    else{
                        right[i]=right[i-1];
                    }
                }
            }
        }

        for(int i=dominoes.length()-1;i>=0;i--){
            char ch =dominoes.charAt(i);
            if(ch=='R'){
                left[i]=-1;
            }
            else{
                if(i==dominoes.length()-1){
                    if(ch=='L'){
                        left[i]=i;
                    }
                    else{
                        left[i]=-1;
                    }   
                }
                else{
                    if(ch=='L'){
                        left[i]=i;
                    }
                    else{
                        left[i]=left[i+1];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<dominoes.length();i++){
            if(right[i]==-1 && left[i]==-1){
                sb.append('.');
            }
            else if(right[i]==-1){
                sb.append('L');
            }
            else if (left[i]==-1){
                sb.append('R');
            }
            else{
                int distfromleft = Math.abs(i-right[i]);// pushing right
                int distfromright = Math.abs(i-left[i]);//pushing left

                if(distfromleft<distfromright){
                    sb.append('R');
                }
                else if(distfromleft>distfromright){
                    sb.append('L');
                }
                else{
                    sb.append('.');
                }
            }

        }

        return sb.toString();


    }
}