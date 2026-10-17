class Solution {
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
        @Override
        public String toString() {
            return "State{num="+num+",digitSum="+digitSum+",originalIndex="+originalIndex+"}";
        }
    }
    public int minSwaps(int[] nums) {
        State[] states = new State[nums.length];
        for(int i = 0; i < nums.length; i++) {
            states[i] = new State(nums[i],i);
        }
        // Swapping 2 nums that just need to switch positions -> 1 turn
        // Placing 1 num correctly otherwise -> 1 turn
        Arrays.sort(states, (a,b) -> {
            if(a.digitSum != b.digitSum) return a.digitSum - b.digitSum;
            return a.num - b.num;
        });
        int r = 0;
        for(int i = 0; i < states.length; i++) {
            if(states[i].originalIndex == i) continue;
            boolean redo = false;
            if(states[states[i].originalIndex].originalIndex != states[i].originalIndex) {
                redo = true;
            }
            int temp = states[i].originalIndex;
            states[i].originalIndex = states[states[i].originalIndex].originalIndex;
            states[temp].originalIndex = temp;
            r++;
            if(redo) i--;
        }
        return r;
    }
    //    
    //    State{num=16,digitSum=7,originalIndex=3}
    //    State{num=34,digitSum=7,originalIndex=2}
    //    State{num=18,digitSum=9,originalIndex=0}
    //    State{num=43,digitSum=7,originalIndex=1}
    // 
}