// class Solution {
//     public int[] findOrder(int numCourses, int[][] prerequisites) {
//         List<List<Integer>>list = new ArrayList<>();
//         Queue<Integer> que = new ArrayDeque<>();
//         int req[] = new int[numCourses];
//         int result[] = new int[numCourses];

//         for(int i=0;i<numCourses;i++)list.add(new ArrayList<>());
//         for(int i[]:prerequisites)
//         {
//             list.get(i[1]).add(i[0]);
//             req[i[0]]++;
//         }
//         for(int i=0;i<numCourses;i++)if(req[i]==0)que.offer(i);
//         int k=0,count=0;
//         while(!que.isEmpty())
//         {
//             int num = que.poll();
//             for(int nei:list.get(num))
//             {
//                 req[nei]--;
//                 if(req[nei]==0)que.offer(nei);
//             }
//             result[k++]=num;
//         }
//         if(k!=numCourses)return new int[]{};
//         return result;
//     }
// }

class Solution {
    int k=0;
    public boolean dfs(List<List<Integer>>list,int [] dist,int []result,int curr)
    {
        if(dist[curr] == 1)return true;
        if(dist[curr] == 2)return false;
        dist[curr] = 1;
        for(int i:list.get(curr))
        {
            if(dfs(list,dist,result,i))return true;
        }
        dist[curr] = 2;
        result[k++]=curr;
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>>list = new ArrayList<>();
        Queue<Integer> que = new ArrayDeque<>();
        int dist[] = new int[numCourses];
        int result[] = new int[numCourses];

        for(int i=0;i<numCourses;i++)list.add(new ArrayList<>());
        for(int i[]:prerequisites) list.get(i[1]).add(i[0]);
        for(int i=0;i<numCourses;i++)
        {
            if(dfs(list,dist,result,i))return new int[]{};
        }
        for (int i = 0; i < numCourses; i++) 
        {
            dist[i] = result[numCourses - 1 - i];
        }
        return dist;
    }
}
