class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int l = 0;
        int r = 0;
        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(r<n){
            // Include current fruit in the map
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) +1);

              
            // More than 2 types of fruits
            if(map.size() > 2){
                // Remove one fruits from the left
                map.put(fruits[l], map.get(fruits[l]) - 1);
                // If count becomes 0, remove that fruit type
               if(map.get(fruits[l]) == 0){
                map.remove(fruits[l]);
               }
               l++;
            }

            //calculate the window length
            if(map.size() <= 2){
                maxLen = Math.max(maxLen, r - l +1);
            }
            //mov right pointer
            r++;
        }
        return maxLen;
    }
}