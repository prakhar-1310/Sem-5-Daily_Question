class Solution {
    public double minTime(int n, int k, int m, int[] time, double[] mul) {
        int maxMask = 1<<n;

        if(k==1 && n>1){
            return -1;
        }

        boolean visited[][][] = new boolean[maxMask][m][2];

        List<int[]>validGrp = new ArrayList<>();
        for(int i=1;i<maxMask; i++){
            if(countBit(i)<=k){
                validGrp.add(new int[] {i, maxTime(time,i)});
            }
        }

        PriorityQueue<Pair>pq = new PriorityQueue<>((a,b)->{
            return Double.compare(a.cost,b.cost);
        });
        pq.add(new Pair(0,0,0,0));

        while(!pq.isEmpty()){
            Pair rm = pq.poll();

            if(visited[rm.mask][rm.stage][rm.side]) continue;

            visited[rm.mask][rm.stage][rm.side]=true;

            if(rm.mask==(1<<n)-1) return rm.cost;

            if(rm.side == 0){
                for(int grp[] : validGrp){
                    int grpMask = grp[0];
                    int maxTime = grp[1];
                    if((rm.mask & grpMask)!=0){
                        continue;
                    }
                    double tim = maxTime*mul[rm.stage];
                    int newStage = (rm.stage + (int)Math.floor(tim))%m;
                    int newMask = rm.mask | grpMask;

                    if(!visited[newMask][newStage][1]){
                        pq.add(new Pair(newMask,newStage,1,rm.cost+tim));
                    }
                }
            }
            else{
                for(int i=0;i<n;i++){
                    if((rm.mask & (1<<i))!=0){
                        double tim = mul[rm.stage]*time[i];
                        int newStage = (rm.stage + (int)Math.floor(tim))%m;
                        int newMask = rm.mask^(1<<i);

                        if (!visited[newMask][newStage][0]) {
                            pq.offer(new Pair(newMask, newStage, 0, rm.cost+tim));
                        }
                    }
                }
            }
        }

        return -1;
    }

    public int maxTime(int time[], int val){
        int max = Integer.MIN_VALUE;
        int i=0;
        while(val>0){
            if((val&1)==1){
                max = Math.max(max,time[i]);
            }
            i++;
            val>>=1;
        }

        return max;
    }

    public int countBit(int x){
        int cnt=0;
        while(x>0){
            if((x&1)==1){
                cnt++;
            }
            x>>=1;
        }
        return cnt;
    }

    class Pair{
        int mask;
        int stage;
        int side;
        double cost;
        public Pair(int mask, int stage, int side, double cost){
            this.mask=mask;
            this.cost=cost;
            this.side=side;
            this.stage=stage;
        }
    }
}