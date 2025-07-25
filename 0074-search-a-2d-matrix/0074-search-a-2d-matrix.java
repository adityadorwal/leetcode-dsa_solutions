class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row_size = matrix.length,col_size = matrix[0].length;
        for (int i=0;i<row_size;i++)
        {
            if(target<=matrix[i][col_size-1])
            {
                int s=0,l=col_size,mid;
                while(s<=l)
                {
                    mid=(s+l)/2;
                    if(matrix[i][mid]==target)return true;
                    else if(matrix[i][mid]>target)l=mid-1;
                    else s=mid+1;
                }
                return false;
            }
        }
        return false;
    }
}