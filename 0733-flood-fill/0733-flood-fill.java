class Solution {
    public void floodFill(int[][] image, int r, int c, int color,int r_len,int c_len,int check)
    {
        if(r<0 || r>=r_len || c<0 || c>=c_len || image[r][c]!=check || image[r][c]==color)return;
        image[r][c] = color;
        floodFill(image,r-1,c,color,r_len,c_len,check);
        floodFill(image,r,c-1,color,r_len,c_len,check);
        floodFill(image,r,c+1,color,r_len,c_len,check);
        floodFill(image,r+1,c,color,r_len,c_len,check);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        floodFill(image , sr , sc , color , image.length , image[0].length , image[sr][sc]);
        return image;
    }
}