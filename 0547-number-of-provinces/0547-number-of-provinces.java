/************************************************BFS Approch******************************************* */

// class Solution {
//     public int findCircleNum(int[][] isConnected) {
//         boolean visited[] = new boolean[isConnected.length];
//         int count=0;
//         for(int i=0;i<visited.length;i++)
//         {
//             if(!visited[i])
//             {
//                 count++;
                
//                 visited[i]=true;
//                 Deque<Integer> que = new ArrayDeque<>();
//                 que.offerFirst(i);

//                 while(!que.isEmpty())
//                 {
//                     int arr[] = isConnected[que.poll()];
//                     for(int k=0; k<arr.length;k++)
//                     {
//                         if(arr[k]==1 && !visited[k])
//                         {
//                             visited[k]=true;
//                             que.offer(k);
//                         }
//                     }
//                 }
//             }
//         }
//         return count;
//     }
// }

/********************************************************DFS Approch***************************************** */

class Solution {
    public void dfs(int[][] isConnected, boolean[] visited,int i)
    {
        int arr[] = isConnected [i];
        visited[i]=true;
        for(int k=0;k<isConnected.length;k++)
        {
            if(arr[k]==1 && !visited[k])dfs(isConnected ,visited,k);
        }
    }
    public int findCircleNum(int[][] isConnected) {
        boolean visited[] = new boolean[isConnected.length];
        int count=0;
        for(int i=0;i<isConnected.length;i++)
        {
            if(!visited[i])
            {
                count++;
                dfs(isConnected,visited,i);
            }
        }
        return count;
    }
}