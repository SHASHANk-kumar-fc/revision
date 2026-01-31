class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer>q=new LinkedList<>();
        q.add(0);
        ArrayList<Integer>l=new ArrayList<>();
        boolean visit[]=new boolean[adj.size()];
        while(!q.isEmpty()){
            int val=q.poll();
            visit[val]=true;
            l.add(val);
            int x=0;
            while(x<adj.get(val).size()){
                int value=adj.get(val).get(x);
                if(!visit[value]){q.add(value);
                    visit[value]=true;
                }
                x++;
            }
        }

        return l;
    }
}