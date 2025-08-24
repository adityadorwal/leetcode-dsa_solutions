class NumMatrix {
    int [][]arr;
    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        arr = new int[row][col+1];
        for(int i=0; i<row;i++)
        {
            int sum = 0;
            for(int j=1;j<=col;j++) 
            {
                sum += matrix[i][j-1];
                arr[i][j] = sum;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum=0;
        while(row1<=row2)
        {
            sum += (arr[row1][col2+1] - arr[row1++][col1]);
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */