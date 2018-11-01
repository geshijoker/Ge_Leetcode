
class MedianFinder {

    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    
    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        maxHeap = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (double) (minHeap.peek() + maxHeap.peek()) / 2;
        } else {
            return maxHeap.peek();
        }
    }
}
