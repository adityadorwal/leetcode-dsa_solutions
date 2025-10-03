// class Solution {
//     public int trapRainWater(int[][] heightMap) {
//         int m = heightMap.length;
//         int n = heightMap[0].length;
//         if(m<3 || n<3)return 0;
//         PriorityQueue<int []> que = new PriorityQueue<>((a,b)->a[0]-b[0]);
//         for(int i=0;i<m;i++)
//         {
//             que.offer(new int[]{heightMap[i][0],i,0});
//             que.offer(new int[]{heightMap[i][n-1],i,n-1});
//             heightMap[i][0]=-1;
//             heightMap[i][n-1]=-1;
//         }
//         for(int i=0;i<n;i++)
//         {
//             que.offer(new int[]{heightMap[0][i],0,i});
//             que.offer(new int[]{heightMap[m-1][i],m-1,i});
//             heightMap[0][i]=-1;
//             heightMap[m-1][i]=-1;
//         }
        
//         int sum=0,max_num=0;
//         int dir[][] = {{-1,0},{1,0},{0,1},{0,-1}};
//         while(!que.isEmpty())
//         {
//             int arr[] = que.poll();
//             int w=arr[0],i=arr[1],j=arr[2];
//             max_num=Math.max(max_num,w);

//             for(int []k:dir)
//             {
//                 int a = i+k[0], b = j+k[1];
//                 if(a>0 && b>0 && a<m && b<n && heightMap[a][b]!=-1)
//                 {
//                     int curr = heightMap[a][b];
//                     if(curr<max_num) sum+= max_num-curr;
//                     heightMap[a][b] = -1;
//                     que.offer(new int[]{curr,a,b});
//                 }
//             }
//         }
//         return sum;
//     }
// }


class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        if (m < 3 || n < 3) return 0; // too small for water

        int maxH = 0;
        for (int[] row : heightMap) {
            for (int h : row) {
                maxH = Math.max(maxH, h);
            }
        }

        // buckets: each index stores list of cells with that boundary height
        List<int[]>[] buckets = new List[maxH + 1];
        for (int i = 0; i <= maxH; i++) {
            buckets[i] = new ArrayList<>();
        }

        boolean[][] visited = new boolean[m][n];

        // put all boundary cells into buckets
        for (int i = 0; i < m; i++) {
            addToBucket(buckets, heightMap[i][0], i, 0);
            addToBucket(buckets, heightMap[i][n-1], i, n-1);
            visited[i][0] = visited[i][n-1] = true;
        }
        for (int j = 0; j < n; j++) {
            addToBucket(buckets, heightMap[0][j], 0, j);
            addToBucket(buckets, heightMap[m-1][j], m-1, j);
            visited[0][j] = visited[m-1][j] = true;
        }

        int trapped = 0;
        int waterLevel = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        // process buckets in increasing order of height
        for (int h = 0; h <= maxH; h++) {
            List<int[]> bucket = buckets[h];
            while (!bucket.isEmpty()) {
                int[] cell = bucket.remove(bucket.size() - 1);
                int r = cell[0], c = cell[1];
                waterLevel = Math.max(waterLevel, h);

                for (int[] d : dirs) {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr < 0 || nc < 0 || nr >= m || nc >= n || visited[nr][nc]) continue;

                    visited[nr][nc] = true;
                    int nh = heightMap[nr][nc];

                    if (nh < waterLevel) {
                        trapped += waterLevel - nh;
                        addToBucket(buckets, waterLevel, nr, nc); 
                    } else {
                        addToBucket(buckets, nh, nr, nc);
                    }
                }
            }
        }

        return trapped;
    }

    private void addToBucket(List<int[]>[] buckets, int h, int r, int c) {
        buckets[h].add(new int[]{r, c});
    }
}
