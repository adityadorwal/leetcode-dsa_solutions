class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        int min_diff = Integer.MAX_VALUE;
        int len = arr.length;
        List<Integer> temp;
        for (int i = 0; i < len - 1; i++) {
            int a = arr[i], b = arr[i + 1];
            int diff = b - a;
            if (diff > min_diff)
                continue;
            else if (diff < min_diff) {
                result.clear();
                min_diff = diff;
            }
            temp = new ArrayList<>();
            temp.add(a);
            temp.add(b);
            result.add(temp);
        }
        return result;
    }
}