class Solution {
    public void solve(char[][] board) {
        int n=board.length,m=board[0].length;
        boolean [][] visit=new boolean [n][m];
        Queue<int[]>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i==0 ||i==n-1 ||j==0 ||j==m-1 )&&board[i][j]=='O' &&!visit[i][j]){
                    q.add(new int[]{i,j});
                    visit[i][j]=true;rec(visit,q,board);
                }
            }}for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visit[i][j] && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }}

    }public static void rec(boolean[][]visit,Queue<int[]>q,char[][]board){int []dr=new int[]{-1,0,1,0};int dc[]=new int[]{0,1,0,-1};
        while(!q.isEmpty()){
            int pair[]=q.poll();

            int x=0,r=pair[0],c=pair[1];
            while(x<4){
                int row=r+dr[x],col=c+dc[x];
                if(row>=0&&col>=0&&row<board.length &&col<board[0].length&& !visit[row][col]&&board[row][col]=='O'){
                    visit[row][col]=true;
                    q.add(new int[]{row,col});
                }x++;
            }
        }
    }
}