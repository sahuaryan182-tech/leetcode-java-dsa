class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if((n % groupSize) != 0){
            return false;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int num : hand){
            map.put(num, map.getOrDefault(num, 0) +1);
        }
        
        while(!map.isEmpty()){
            int curr = map.firstKey();
            //form a grop groupsize consequtive number
            for(int i = 0; i<groupSize; i++){
                int num  = curr + i;
                if(!map.containsKey(num)){
                    return false;
                }
                // Decrease the frequncy
                int freq = map.get(num);

                if(freq == 1){
                    map.remove(num);
                }
                else{
                    map.put(num, freq-1);
                }
            }
        }
        return true;
    }
}