class Solution {
    public int[] getGreaterOrSmallerElementIndices(int[] arr, int defaultIndex, boolean isGreater) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++) {
            int ind =  (defaultIndex == -1) ? i : (n - 1 - i);
            res[ind] = defaultIndex;
            while(isGreater && !st.isEmpty() && ((defaultIndex == -1 && arr[st.peek()] < arr[ind]) || (defaultIndex != -1 && arr[st.peek()] <= arr[ind]))) {
                st.pop();
            }

            while(!isGreater && !st.isEmpty() && ((defaultIndex == -1 && arr[st.peek()] > arr[ind]) || (defaultIndex != -1 && arr[st.peek()] >= arr[ind]))) {
                st.pop();
            }

            if(!st.isEmpty()) {
                res[ind] = st.peek();
            }
            st.push(ind);
        }

        return res;
    }

    public long getCount(int left, int right, int ind, int k) {
        right = Math.min(right, ind + k - 1);
        int first_ind = Math.max(left, ind - k + 1);
        int second_ind = Math.max(left, right - k + 1);
        long count = (ind - second_ind + 1) * (right - ind + 1);
        if(first_ind < second_ind) {
            int num = second_ind - first_ind;
            count += (num * (2*(right - ind) - num + 1)) / 2;
        }
        return count;
    }

    public long minMaxSubarraySum(int[] nums, int k) {
        int[] prevGreater = getGreaterOrSmallerElementIndices(nums, -1, true);
        int[] nextGreater = getGreaterOrSmallerElementIndices(nums, nums.length, true);
        int[] prevSmaller = getGreaterOrSmallerElementIndices(nums, -1, false);
        int[] nextSmaller = getGreaterOrSmallerElementIndices(nums, nums.length, false);
        long count = 0;
        for(int ind = 0; ind < nums.length; ind++) {
            int left_max = prevGreater[ind] + 1;
            int right_max = nextGreater[ind] - 1;
            int left_min = prevSmaller[ind] + 1;
            int right_min = nextSmaller[ind] - 1;

            right_max = Math.min(right_max, ind + k - 1);
            right_min = Math.min(right_min, ind + k - 1);

            long count_max = getCount(left_max, right_max, ind, k);
            long count_min = getCount(left_min, right_min, ind, k);
            count += (count_max + count_min) * nums[ind];
        }
        return count;
    }
}