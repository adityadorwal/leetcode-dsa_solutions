class Solution {
    int r_len,c_len ;
    public int max_len(int [][]mat, int threshold , int i, int j, int count)
    {
        int a = i+count, b = j+count;
        if(a == r_len || b == c_len )return count;
        
        int curr_i = a-1, curr_j = b-1;
        threshold -= mat[a][b];
        while(curr_i>=i && curr_j>=j)
        {
            threshold -= (mat[curr_i][b]+mat[a][curr_j]);
            curr_i--;
            curr_j--;
            if(threshold < 0)return count;
        }
        return max_len(mat,threshold,i,j,count+1);
    }

    public int maxSideLength(int[][] mat, int threshold) {
        r_len = mat.length;
        c_len = mat[0].length;
        int result=0;
        for(int i=0;i<r_len;i++)
        {
            for(int j=0;j<c_len;j++)
            {
                if(mat[i][j] <= threshold)
                {
                    // System.out.println(max_len(mat, threshold,i,j,0));
                    result = Math.max(result,max_len(mat, threshold-mat[i][j],i,j,1));
                }
            }
        }
        return result;
    }
}