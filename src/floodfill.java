class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color)return image;
        int n=image.length,m=image[0].length;
        int original=image[sr][sc];
        image[sr][sc]=color;
        Queue<int[]>q=new LinkedList<>();
        q.add(new int[]{sr,sc});
        while(!q.isEmpty()){
            int []pair=q.poll();
            int r=pair[0];
            int c=pair[1];
            int[]dr=new int[]{-1,0,1,0};
            int[] dc=new int[]{0,1,0,-1};
            int x=0;
            while(x<4){
                int row=dr[x]+r;
                int col=dc[x]+c;
                if(row>=0 && col<m &&row<n &&col>=0 && image[row][col]==original){
                    image[row][col]=color;
                    q.add(new int[]{row,col});
                }
                x++;
            }
        }return image;
    }
}