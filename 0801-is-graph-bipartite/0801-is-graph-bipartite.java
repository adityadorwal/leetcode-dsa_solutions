// class Solution {
//     Queue<Integer> que;

//     public boolean bfs(int[][] graph , int[] visited , int start) {
//         que = new ArrayDeque<>();
//         que.offer(start);
//         visited[start] = 1; // start with color 1

//         while(!que.isEmpty()) {
//             int curr = que.poll();
//             for(int nei : graph[curr]) {
//                 if(visited[nei] == 0) {
//                     // assign opposite color of curr
//                     visited[nei] = (visited[curr] == 1) ? 2 : 1;
//                     que.offer(nei);
//                 } 
//                 else if(visited[nei] == visited[curr]) {
//                     return false; // same color conflict
//                 }
//             }
//         }
//         return true;
//     }

//     public boolean isBipartite(int[][] graph) {
//         int visited[] = new int[graph.length];

//         for(int i=0; i<graph.length; i++) {
//             if(visited[i] == 0) {
//                 if(!bfs(graph, visited, i)) return false;
//             }
//         }
//         return true;
//     }
// }

class Solution {
    public boolean dfs(int[][] graph ,int visited [] , int col , int curr)
    {
        visited[curr] = col;
        col = (col==1)?2:1;

        for(int nei:graph[curr])
        {
            if(visited[nei]==0 && (!dfs(graph,visited,col,nei)))return false;
            else if(visited[nei]!=col)return false;
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int visited[] = new int[graph.length];
        for(int i=0;i<graph.length;i++)
        {
            if(visited[i]==0)
            {
                if(!dfs(graph, visited, 1,i))return false;
            }
        }
        return true;
    }
}