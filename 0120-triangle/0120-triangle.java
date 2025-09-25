// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         for(int i=triangle.size()-2 ; i>=0 ; i--)
//         {
//             for(int j=0;j<=i;j++)
//             {
//                 int curr = triangle.get(i).get(j);
//                 int min = Math.min(triangle.get(i+1).get(j) , triangle.get(i+1).get(j+1));
//                 triangle.get(i).set(j,curr + min);
//             }
//         }
//         return triangle.get(0).get(0);
//     }
// }

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int dp[] = new int[n];

        for(int i=0;i<n;i++) dp[i]=triangle.get(n-1).get(i);

        for(int i=n-2;i>=0;i--)
        {
            for(int j=0;j<=i;j++)
            {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]);
            }
        }
        return dp[0];
    }
}