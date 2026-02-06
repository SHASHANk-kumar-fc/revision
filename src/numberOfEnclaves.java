class Solution {
    public int numEnclaves(int[][] grid) {
        Queue<int[]>  q=new LinkedList<>();
        int count=0;
        int n=grid.length,m=grid[0].length;
        boolean[][]v=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i==0 ||j==0 || i==n-1 ||j==m-1)&&!v[i][j] && grid[i][j]==1){
                    q.add(new int[]{i,j});
                    v[i][j]=true;
                    bfs(v,q,grid,n,m);
                }
            }
        }for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!v[i][j]&& grid[i][j]==1)
                    count++;
            }}return count;
    }
    public static void bfs(boolean [][]v,Queue<int[]>q,int[][]grid,int n,int m){
        while(!q.isEmpty()){
            int dr[]=new int[]{-1,1,0,0};
            int dc[]=new int[]{0,0,-1,1};
            int x=0;
            int pair[]=q.poll();
            int r=pair[0],c=pair[1];

            while(x<4){
                int row=dr[x]+r,col=dc[x]+c;
                if(row>=0 &&col>=0 && col<m && row<n && grid[row][col]==1 &&!v[row][col]){
                    q.add(new int[]{row,col});
                    v[row][col]=true;
                }x++;
            }
        }
    }

}