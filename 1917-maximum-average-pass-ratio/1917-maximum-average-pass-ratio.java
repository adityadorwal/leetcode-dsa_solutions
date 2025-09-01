import java.util.*;

class Solution {
    // Helper: compute marginal gain if we add one guaranteed-pass student to (p, t)
    private double gain(int p, int t) {
        return ((double)(p + 1) / (t + 1)) - ((double)p / t);
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // Max-heap by highest marginal gain
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            double ga = ((double)(a[0] + 1) / (a[1] + 1)) - ((double)a[0] / a[1]);
            double gb = ((double)(b[0] + 1) / (b[1] + 1)) - ((double)b[0] / b[1]);
            return Double.compare(gb, ga); // descending
        });

        // Load all classes
        for (int[] c : classes) pq.offer(new int[]{c[0], c[1]});

        // Assign extra students one by one to the best class each time
        while (extraStudents-- > 0) {
            int[] top = pq.poll();
            top[0]++; // one more pass
            top[1]++; // one more total
            pq.offer(top); // recompute its gain implicitly on next comparison
        }

        // Compute final average
        double sum = 0.0;
        int n = classes.length;
        while (!pq.isEmpty()) {
            int[] c = pq.poll();
            sum += (double)c[0] / c[1];
        }
        return sum / n;
    }
}
