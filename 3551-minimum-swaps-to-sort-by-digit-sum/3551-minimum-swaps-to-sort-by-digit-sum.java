class Solution {
    public int minSwaps(int[] nums) {
        State[] state = new State[nums.length];
        for(int i = 0; i < nums.length; i++) {
            state[i] = new State(nums[i],i);
        }
        // Swapping 2 nums that just need to switch positions -> 1 turn
        // Placing 1 num correctly otherwise -> 1 turn
        Arrays.sort(state, (a,b) -> {
            if(a.digitSum != b.digitSum) return a.digitSum - b.digitSum;
            return a.num - b.num;
        });
        int r = 0;
        for(int i = 0; i < state.length; i++) {
            if(state[i].originalIndex == i)continue;
            boolean redo = false;
            if(state[state[i].originalIndex].originalIndex!=state[i].originalIndex){
                redo=true;
            }

            int temp = state[i].originalIndex;
            state[i].originalIndex = state[temp].originalIndex;
            state[temp].originalIndex = temp;

            r++;
            if(redo)i--;
        }
        return r;
    }

    class State {
        int num;
        int digitSum;
        int originalIndex;
        public State(int num, int originalIndex) {
            this.num = num;
            this.originalIndex = originalIndex;
            int c = num;
            while(c > 0) {
                this.digitSum += c % 10;
                c /= 10;
            }
        }
    }
    //    
    //    State{num=16,digitSum=7,originalIndex=3}
    //    State{num=34,digitSum=7,originalIndex=2}
    //    State{num=18,digitSum=9,originalIndex=0}
    //    State{num=43,digitSum=7,originalIndex=1}
}