class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        int n=grid.length,m=grid[0].length;
        boolean visit[][]=new boolean[n][m];int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visit[i][j] && grid[i][j]==2){
                    visit[i][j]=true;
                    q.add(new int[]{i,j,count});
                }
            }
        }
        while(!q.isEmpty()){
            int pair[]=q.poll();
            int r=pair[0];int[]dr=new int[]{-1,0,1,0};
            int c=pair[1];int[] dc=new int[]{0,1,0,-1};
            count=pair[2];
            int x=0;
            while(x<4){int row=r+dr[x];int col=c+dc[x];
                if(row>=0 && col<m &&row<n &&col>=0 && !visit[row][col] &&grid[row][col]==1){
                    visit[row][col]=true;
                    q.add(new int []{row,col,count+1});
                }  x++;
            }
        }

        for(int row=0;row<n;row++){
            for(int col=0;col<m;col++){
                if(!visit[row][col] && grid[row][col]==1){
                    return -1;
                }
            }
        }return count;
    }
}