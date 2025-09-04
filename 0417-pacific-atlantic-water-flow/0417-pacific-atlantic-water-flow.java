class Solution {
    int direct[][] = {{-1,0},{0,1},{1,0},{0,-1}};
    public void dfs(int[][] heights,boolean [][]visited , int i, int j, int r, int c)
    {
        visited[i][j]=true;
        for(int []arr:direct)
        {
            int a = arr[0]+i;
            int b = arr[1]+j;
            if(a>=0 && b>=0 && a<r && b<c && !visited[a][b] && heights[i][j]<=heights[a][b])
            {
                dfs(heights,visited,a,b,r,c);
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int r=heights.length,c=heights[0].length;
        boolean [][]pacific = new boolean[r][c];
        boolean [][]atlantic = new boolean[r][c];
        
        for(int i=0;i<c;i++)
        {
            dfs(heights,pacific,0,i,r,c);
            dfs(heights,atlantic,r-1,i,r,c);
        }
        for(int i=0;i<r;i++)
        {
            dfs(heights,pacific,i,0,r,c);
            dfs(heights,atlantic,i,c-1,r,c);
        }

        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(pacific[i][j] && atlantic[i][j])
                {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    result.add(temp);
                }
            }
        }
        return result;
    }
}