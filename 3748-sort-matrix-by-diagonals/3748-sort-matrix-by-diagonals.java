class Solution {
    public void diagonal_sort(int[][]grid , int r, int c)
    {
        if(r==grid.length-1 || c==grid[0].length-1)return;
        PriorityQueue<Integer> pq;
        if(r>=0 && c==0)
        {
            int temp =r;
            pq = new PriorityQueue<>((a,b)->b-a);
            while(r<grid.length) pq.offer(grid[r++][c++]);
            
            c=0;
            r=temp;

            while(r<grid.length) grid[r++][c++]=pq.poll();
            diagonal_sort(grid,temp+1,0);
        }
        else
        {
            int temp =c;
            pq = new PriorityQueue<>();
            while(c<grid[0].length) pq.offer(grid[r++][c++]);
            
            c=temp;
            r=0;

            while(c<grid[0].length) grid[r++][c++]=pq.poll();
            diagonal_sort(grid,0,temp+1);
        }
    }
    public int[][] sortMatrix(int[][] grid) {
        diagonal_sort(grid,0,0);
        diagonal_sort(grid,0,1);
        return grid;
    }
}