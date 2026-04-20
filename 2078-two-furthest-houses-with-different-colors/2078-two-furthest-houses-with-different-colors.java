class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int i = 0, j = n - 1;
        int result = 1;
        int s=colors[0] , e=colors[n-1];
        while (i<n) {
            if (s != colors[j]) {
                result = Math.max(result, j);
            }
            j--;

            if (e != colors[i]) {
                result = Math.max(result, n - i - 1);
            }
            i++;
        }
        return result;
    }
}