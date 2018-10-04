public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        if(intervals==null||intervals.size()==0)
            return 0;
 
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start-i2.start;
            }
        });

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        int count=1;
        queue.offer(intervals.get(0).end);
 
        for(int i=1; i<intervals.size(); i++){
            if(intervals.get(i).start<queue.peek()){
                count++;
            }else{
                queue.poll();
            }
 
            queue.offer(intervals.get(i).end);
        }
        return count;
    }
}
