class LastStoneWeight {
    public int lastStoneWeight(int[] stones){
        // reverseOrder implements reverse comparison from > to <
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : stones){
            queue.add(i);
        }
        int x;
        int y;
        while (queue.size() > 1){
            // Extract two highest elements
            y = queue.poll();
            x = queue.poll();
            if (y > x){
                queue.offer(y - x); // Insert specific element
            }
        }
        return queue.isEmpty() ? 0 : queue.poll();
    }

    // Sort in place implementation
    public int lastStoneWeightInPlace(int[] stones){
        Arrays.sort(stones);
        for (int i = stones.length - 1; i > 0; i--){
            stones[i - 1] = stones[i] - stones[i - 1];
            Arrays.sort(stones);
        }
        return stones[0];
    }
}