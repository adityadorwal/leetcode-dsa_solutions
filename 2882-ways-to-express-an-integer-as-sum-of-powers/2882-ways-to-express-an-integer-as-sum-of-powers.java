class Solution {
    private Integer[][] dp;

    public int calculate(int arr[], int target, int indx, int sum, int len) {
        if (sum == target) return 1;
        if (sum > target || indx >= len) return 0;

        if (dp[indx][sum] != null) return dp[indx][sum];

        dp[indx][sum] = (calculate(arr, target, indx + 1, sum + arr[indx], len) + calculate(arr, target, indx + 1, sum, len))%1000000007;
        return dp[indx][sum];
    }

    public int numberOfWays(int n, int x) {
        int min = (int) Math.pow(n, 1.0 / x);
        if (Math.pow(min, x) <= n) min++;

        int arr[] = new int[min];
        for (int i = 0; i < min; i++)
        {
            arr[i] = (int) Math.pow(i + 1, x);
        }
        dp = new Integer[min][n + 1];
        return calculate(arr, n, 0, 0, min);
    }
}
