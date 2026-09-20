class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length; //child greed need -> r pointer
        int m = s.length; ///cookies size -> l ponter
        Arrays.sort(g);
        Arrays.sort(s);
        int l = 0;
        int r = 0;
        while( l  < m && r < n){
            if(g[r] <= s[l]){
                //if true the we statisfied means, move nex child
                r = r+1;
            }
            l = l+1;
        }
        return r;
    }
}