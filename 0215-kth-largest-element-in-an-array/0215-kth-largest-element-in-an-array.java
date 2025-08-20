class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Arrays.sort(nums);  O(nlog(n))
        // return nums[nums.length-k];
        PriorityQueue<Integer>queue = new PriorityQueue<>();
		for(int i=0;i<k;i++) {
			queue.add(nums[i]);
		}
		for(int i=k;i<nums.length;i++) {
			if(nums[i]>queue.peek()) {
				queue.poll();
				queue.add(nums[i]);
			}
		}
		
		return queue.peek();
    }
}