class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;

        // Sorted by ending time
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 1; //intailly frist meeting is 1
        int lastEndTime = intervals[0][1];  //freetime is ending time that one meeting

        // we inculde as frist (index -> 0) meeting, so start at 1 index
        for(int i = 1; i<n; i++){
            // if starting time is lesser the ending time
            if(intervals[i][0] >= lastEndTime){
                count = count + 1; //count the number of meeting
                lastEndTime = intervals[i][1]; //update the ending time
            }
        }

        // final ans is the toatl number of meetings(interval) - the actual meeting we can perform
        int ans = n - count;
        return ans;
        
    }
}