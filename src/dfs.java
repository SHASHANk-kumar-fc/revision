class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        boolean visit[]=new boolean [adj.size()];
        ArrayList<Integer>l=new ArrayList<>();

        dfs(visit,l,adj,0);
        return l;

    }
    public static void dfs(boolean[] visit,ArrayList<Integer>l,ArrayList<ArrayList<Integer>>adj,int val){
        l.add(val);
        visit[val]=true;
        for(int i=0;i<adj.get(val).size();i++){
            if(!visit[adj.get(val).get(i)]){

                dfs(visit,l,adj,adj.get(val).get(i));
            }
        }
    }
}