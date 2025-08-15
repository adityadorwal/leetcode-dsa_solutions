class Solution {
    public boolean search_row(int [] arr, int target , int left , int right)
    {
        while(left<right)
        {
            int mid = left + (right - left)/2;
            if(arr[mid] == target)return true;
            else if(arr[mid] < target)left = mid+1;
            else right = mid-1;
        }
        if(left<arr.length)return arr[left] == target;
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int row_len = matrix[0].length , col_len = matrix.length;
        
        int left=0 , right = row_len;
        while(left<right)
        {
            int mid = left + (right-left)/2;
            if(matrix[0][mid] == target)return true;
            else if(matrix[0][mid] < target)left = mid+1;
            else right = mid-1;
        }
        row_len = (left < row_len)?left+1:left;
        System.out.println(row_len);
        for(int []i : matrix)
        {
            if(i[0]<=target)
            {
                System.out.println(i[0] + " "+ i[row_len-1]);
                if(search_row(i, target , 0 , row_len))return true;
            }
            else
            return false;
        }
        return false;
    }
}