// class Solution {
//     public int equalPairs(int[][] grid) {
//         HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
//         int len = grid.length;
//         int result = 0;
//         for(int i=0;i<len;i++)
//         {
//             int num = grid[0][i];
//             ArrayList<Integer> temp;
//             if(map.containsKey(num))temp = map.get(num);
//             else temp = new ArrayList<>();
//             temp.add(i);
//             map.put(num,temp);
//         }
//         for(int i=0;i<len;i++)
//         {
//             int num = grid[i][0];
//             if(!map.containsKey(num))continue;
//             ArrayList<Integer> arr = map.get(num);
//             for(int k:arr)
//             {
//                 int j=0;
//                 for(j=0;j<len;j++)
//                 {
//                     if(grid[j][k] != grid[i][j])break;
//                 }
//                 if(j == len)result++;
//             }
//         }
//         return result;
//     }
// }


class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<List<Integer>, Integer> rowCount = new HashMap<>();

        // Store all rows
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(grid[i][j]);
            }
            rowCount.put(row, rowCount.getOrDefault(row, 0) + 1);
        }

        int result = 0;

        // Build and check columns
        for (int j = 0; j < n; j++) {
            List<Integer> col = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                col.add(grid[i][j]);
            }
            result += rowCount.getOrDefault(col, 0);
        }

        return result;
    }
}
