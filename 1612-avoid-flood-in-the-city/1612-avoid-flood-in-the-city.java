class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);

        Map<Integer, Integer> full = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            int lake = rains[i];
            if (lake == 0) {
                dryDays.add(i);
                continue;
            }

            res[i] = -1; // raining

            if (full.containsKey(lake)) {
                Integer dry = dryDays.higher(full.get(lake));
                if (dry == null) return new int[0];
                res[dry] = lake;
                dryDays.remove(dry);
            }

            full.put(lake, i);
        }
        return res;
    }
}
