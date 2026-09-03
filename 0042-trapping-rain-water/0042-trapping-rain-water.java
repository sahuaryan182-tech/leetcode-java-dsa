class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int Rightmax = 0;
        int Leftmax = 0;   
        int total = 0;

        int l = 0;
        int r = n-1;

        while(l<r){
            if(height[l] <= height[r]){
                if(Leftmax > height[l]){
                    total = total + Leftmax - height[l];
                }
                else{
                    Leftmax = height[l];
                }
                l = l+1;
            }
            else{
                if(Rightmax > height[r]){
                    total  = total + Rightmax - height[r];
                }
                else{
                    Rightmax = height[r];
                }
                r = r-1;

            }

        }
        return total;
    }
   
}