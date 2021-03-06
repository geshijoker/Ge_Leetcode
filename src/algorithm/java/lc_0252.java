public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start-b.start;
            }
        });
        for(int i=0; i<intervals.size()-1; i++){
            if(intervals.get(i).end>intervals.get(i+1).start){
                return false;
            }
        }
    return true;
    }
}
