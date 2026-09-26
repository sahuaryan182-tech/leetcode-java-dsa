class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] mp = new int[26];
        for(char ch : tasks){
            mp[ch-'A']++;
        }

        int time = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i<26; i++){
            if(mp[i]>0){
                pq.offer(mp[i]);
            }
        }

        while(!pq.isEmpty()){
            List<Integer> temp = new ArrayList<>();
           
            for(int i=1; i<= n + 1; i++){
                if(!pq.isEmpty()){
                int frq = pq.poll();
                frq--;
                temp.add(frq);
                }
            }
            for(int f : temp){
                if( f > 0){
                    pq.offer(f);
                }
            }

            if(pq.isEmpty()){
                time = time + temp.size();
            }
            else{
                time = time + n + 1;
            }
        }
        return time;
    }
}