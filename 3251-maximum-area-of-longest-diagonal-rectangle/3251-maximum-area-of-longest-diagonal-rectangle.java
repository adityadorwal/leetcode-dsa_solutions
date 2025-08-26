class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int result=0;
        int max=0;
        for(int i[] : dimensions)
        {
            int n1 = i[0] , n2 = i[1]; 
            // double num = Math.sqrt((n1*n1)+(n2*n2));
            int num = (n1*n1)+(n2*n2);
            if(num>max)
            {
                max = num;
                result = n1*n2;
            }
            else if(num == max)
            {
                result = Math.max(result,n1*n2);
            }
        }
        return result;
    }
}