class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int LeftSum = 0;
        int RightSum = 0;
        int maxSum = 0;
        // i know the window size is k
        for(int i = 0; i<=k-1; i++){
            // Initially we pick the whole window form the left
            LeftSum = LeftSum + cardPoints[i];
            // Intially we do not pick form right 
            maxSum = LeftSum;        
        }
        //right index (Start with last ele in right)
        int RightIdx = n-1;

        //amd same time we shrink the window k-1 and pick form the Right together do this works
        for(int i = k-1; i>=0; i--){
            //shink form the Leftsum
            LeftSum = LeftSum - cardPoints[i];
            //same time pick(add) form the Right
            RightSum = RightSum + cardPoints[RightIdx];
            //also move the right index to left
            RightIdx = RightIdx - 1;

            maxSum = Math.max(maxSum, (LeftSum + RightSum));
        }
        return maxSum;

    }
}