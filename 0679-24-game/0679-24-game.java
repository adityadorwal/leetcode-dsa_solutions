// import java.util.*;

// class Solution {
//     private static final double EPSILON = 1e-6;

//     public boolean judgePoint24(int[] cards) {
//         List<Double> nums = new ArrayList<>();
//         for (int c : cards) nums.add((double) c);
//         return solve(nums);
//     }

//     private boolean solve(List<Double> nums) {
//         if (nums.size() == 1) {
//             return Math.abs(nums.get(0) - 24) < EPSILON;
//         }

//         for (int i = 0; i < nums.size(); i++) {
//             for (int j = 0; j < nums.size(); j++) {
//                 if (i == j) continue;

//                 List<Double> next = new ArrayList<>();
//                 for (int k = 0; k < nums.size(); k++) {
//                     if (k != i && k != j) next.add(nums.get(k));
//                 }

//                 for (double val : compute(nums.get(i), nums.get(j))) {
//                     next.add(val);
//                     if (solve(next)) return true;
//                     next.remove(next.size() - 1);
//                 }
//             }
//         }
//         return false;
//     }

//     private List<Double> compute(double a, double b) {
//         List<Double> results = new ArrayList<>();
//         results.add(a + b);
//         results.add(a - b);
//         results.add(b - a);
//         results.add(a * b);
//         if (Math.abs(b) > EPSILON) results.add(a / b);
//         if (Math.abs(a) > EPSILON) results.add(b / a);
//         return results;
//     }
// }

class Solution {
    private static final double EPSILON = 1e-6;

    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for (int c : cards) nums.add((double) c);
        return solve(nums);
    }

    private boolean solve(List<Double> nums) {
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24) < EPSILON;
        }

        // try unique pairs (i, j), j > i
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                List<Double> next = new ArrayList<>();
                for (int k = 0; k < nums.size(); k++) {
                    if (k != i && k != j) next.add(nums.get(k));
                }

                // try all results
                for (double val : compute(nums.get(i), nums.get(j))) {
                    next.add(val);
                    if (solve(next)) return true;
                    next.remove(next.size() - 1);
                }
            }
        }
        return false;
    }

    private List<Double> compute(double a, double b) {
        List<Double> results = new ArrayList<>();
        results.add(a + b);
        results.add(a - b);
        results.add(b - a);
        results.add(a * b);
        if (Math.abs(b) > EPSILON) results.add(a / b);
        if (Math.abs(a) > EPSILON) results.add(b / a);
        return results;
    }
}