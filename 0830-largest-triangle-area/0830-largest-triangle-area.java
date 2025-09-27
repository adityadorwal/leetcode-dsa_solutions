class Solution {
    
    // Cross product (for orientation)
    private long cross(int[] O, int[] A, int[] B) {
        return (long)(A[0]-O[0]) * (B[1]-O[1]) - (long)(A[1]-O[1]) * (B[0]-O[0]);
    }
    
    // Convex Hull using Monotone Chain
    private List<int[]> convexHull(int[][] points) {
        Arrays.sort(points, (a,b) -> a[0]!=b[0]? a[0]-b[0] : a[1]-b[1]);
        List<int[]> lower = new ArrayList<>();
        for(int[] p: points) {
            while(lower.size()>=2 && cross(lower.get(lower.size()-2), lower.get(lower.size()-1), p)<=0)
                lower.remove(lower.size()-1);
            lower.add(p);
        }
        List<int[]> upper = new ArrayList<>();
        for(int i=points.length-1;i>=0;i--) {
            int[] p = points[i];
            while(upper.size()>=2 && cross(upper.get(upper.size()-2), upper.get(upper.size()-1), p)<=0)
                upper.remove(upper.size()-1);
            upper.add(p);
        }
        lower.remove(lower.size()-1);
        upper.remove(upper.size()-1);
        lower.addAll(upper);
        return lower;
    }
    
    // Area function
    private double area(int[] a, int[] b, int[] c) {
        return Math.abs((long)a[0]*(b[1]-c[1]) + (long)b[0]*(c[1]-a[1]) + (long)c[0]*(a[1]-b[1])) / 2.0;
    }
    
    public double largestTriangleArea(int[][] points) {
        List<int[]> hull = convexHull(points);
        int n = hull.size();
        double maxArea = 0;
        
        // Rotating calipers: check every pair (i,j) as base
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                int k = (j+1)%n; // start third point
                int startK = k;
                double baseArea = area(hull.get(i), hull.get(j), hull.get(k));
                
                // Move k while area increases
                while(true) {
                    int nextK = (k+1)%n;
                    double nextArea = area(hull.get(i), hull.get(j), hull.get(nextK));
                    if(nextArea > baseArea) {
                        baseArea = nextArea;
                        k = nextK;
                        if(k == startK) break; // full loop
                    } else break;
                }
                maxArea = Math.max(maxArea, baseArea);
            }
        }
        return maxArea;
    }
}