class Solution {
    public int reverse(int a) {
        int num = 0;
        while (a > 0) {
            int r = a % 10;
            num = (num * 10) + r;
            a = a / 10;
        }
        return num;
    }

    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int rev = reverse(nums[i]);

            if (map.containsKey(nums[i])) {
                result = Math.min(result, i - map.get(nums[i]));
            }

            map.put(rev, i);
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}