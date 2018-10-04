/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals==null || intervals.size()==0)
            return intervals;
        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];
        List<Interval> res = new ArrayList<>(n);
        for(int i=0;i<n;i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        Interval temp = new Interval(start[0], end[0]);
        for(int i=1;i<n;i++) {
            if(end[i-1]>=start[i]) {
                temp.end = Math.max(temp.end,end[i]);
            }else {
                res.add(temp);
                temp = new Interval(start[i], end[i]);
            }
        }
        res.add(temp);
        return res;
    }
}
