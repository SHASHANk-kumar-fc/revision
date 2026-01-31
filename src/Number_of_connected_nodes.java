class Solution {
    public int countComponents(int n, int[][] edges) {



        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u); // undirected graph
        }
        boolean[]visit=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!visit[i]){
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                visit[i]=true;
                bfs(visit,adj,q);
                count++;
            }
        }
        return count;
    }public static void bfs(boolean []visit,ArrayList<ArrayList<Integer>> adj,Queue<Integer>q){
        while(!q.isEmpty()){
            int val=q.poll();
            int x=0;
            while(x<adj.get(val).size()){
                int value=adj.get(val).get(x);
                if(!visit[value]){
                    visit[value]=true;
                    q.add(value);
                }
                x++;
            }
        }
    }
}