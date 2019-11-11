class Solution1167 {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i: sticks) queue.add(i);
        int ans = 0;
        while(queue.size()>1) {
            int one = queue.poll();
            int two = queue.poll();
            queue.add(one + two);
            ans = ans + one + two;
        }
        return ans;
    }
}
