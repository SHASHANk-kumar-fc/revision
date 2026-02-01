class Solution {
    public boolean isCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n=V;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[]visit=new boolean[V];
        Queue<int[]>q=new LinkedList<>();


        for(int i=0;i<n;i++)
        {  if(!visit[i])
        {  q.add(new int[]{i,-1});
            while(!q.isEmpty()){
                int pair[]=q.poll();
                int prev=pair[1],index=pair[0];
                int x=0;
                while(x<adj.get(index).size()){
                    int value=adj.get(index).get(x);
                    if(!visit[value] && prev!=value){
                        visit[value]=true;
                        q.add(new int[]{value,index});
                    }else if(visit[value] &&prev!=value)return true;
                    x++;
                }
            }}}
        return false;
    }
}