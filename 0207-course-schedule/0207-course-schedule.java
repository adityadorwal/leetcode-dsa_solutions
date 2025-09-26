// class Solution {
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         List<List<Integer>> list = new ArrayList<>();
//         int dist[] = new int[numCourses];
//         int count=0;

//         for(int i=0;i<numCourses;i++)list.add(new ArrayList<>());
//         for(int []arr:prerequisites)
//         {
//             list.get(arr[1]).add(arr[0]);
//             dist[arr[0]]++;
//         }
//         Queue<Integer>que = new ArrayDeque<>();
//         for(int i=0;i<numCourses;i++)if(dist[i]==0)que.offer(i);

//         while(!que.isEmpty())
//         {
//             int curr = que.poll();
//             count++;
//             for(int i:list.get(curr))
//             {
//                 dist[i]--;
//                 if(dist[i]==0)que.offer(i);
//             }
//         }
//         return (count == numCourses);
//     }
// }

class Solution {
    public boolean dfs(List<List<Integer>> list , int k, int[] dist)
    {
        if(dist[k]==1)return true;
        if(dist[k]==2)return false;

        dist[k]=1;
        for(int i:list.get(k)) if(dfs(list,i,dist))return true;
        dist[k]=2;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        int dist[] = new int[numCourses];
        int count=0;

        for(int i=0;i<numCourses;i++)list.add(new ArrayList<>());
        for(int []arr:prerequisites)list.get(arr[1]).add(arr[0]);
        for(int i=0;i<numCourses;i++) if(dfs(list,i,dist))return false;
        return true;
    }
}