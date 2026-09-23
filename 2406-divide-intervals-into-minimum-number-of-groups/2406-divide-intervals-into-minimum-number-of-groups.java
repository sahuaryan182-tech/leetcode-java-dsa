class Solution {
    public int minGroups(int[][] intervals) {
        int n = intervals.length;

        int[] arr = new int[n];
        int[] dep = new int[n];

        for(int i = 0; i<n; i++){
            arr[i] = intervals[i][0];
            dep[i] = intervals[i][1];
        }

        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 0; // Arrival pointer
        int j = 0; // Departure pointer

        int Platfrom = 0;

        int MaxCount = 0;

        while( i < n){
            // if some is Arrived frist in platform then dep
            if(arr[i] <= dep[j]){
                Platfrom++;
                i++;
            }
            else{ // If someone is depature frist in platform then arr
                Platfrom--;
                j++;
            }
            MaxCount = Math.max(MaxCount, Platfrom);
        }
        return MaxCount;
    }
}