class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int maxArea = 0;
        int l = 0;
        int r = n-1;
        int Area = 0;
        while(l<r){
            int heigt = Math.min(height[l], height[r]);
            int width = r-l;
            Area = heigt * width;
            maxArea = Math.max(maxArea, Area);
            if(height[l] <= height[r]){
                l++;
            }
            else{
                r--;
            }

        }
        return maxArea;
    }
}