class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length,m=mat[0].length;
        boolean[][]visit =new boolean[n][m];
        Queue<int []>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j,0} );
                    visit[i][j]=true;
                }
            }
        }
        while(!q.isEmpty()){
            int[]pair=q.poll();
            mat[pair[0]][pair[1]]=pair[2];
            int []dr=new int[]{-1,0,1,0};
            int []dc=new int[]{0,1,0,-1};
            int x=0;
            while(x<4){int r=pair[0]+dr[x],c=pair[1]+dc[x];
                if(r>=0 && r<n &&c>=0 && c<m && !visit[r][c] ){
                    q.add(new int[]{r,c,pair[2]+1});
                    visit[r][c]=true;
                }x++;
            }
        }return mat;
    }
}