class Solution {
    public int[] arrayRankTransform(int[] arr) {
        
        int n = arr.length;
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        HashMap<Integer, Integer> map = new HashMap<>(); //element, rank
        int rank = 1;
        for( int num : sorted){
            if(!map.containsKey(num)){
                map.put(num, rank++); // rank++ post fix frist rank is use and then  Inreacse a rank
            }

        }
        int[] res = new int[n];

        for(int i = 0; i<n; i++){
            res[i] = map.get(arr[i]);
        }
        return res;

    }
}