class Solution {

    int destination;
    int[] dist;
    HashMap<Integer, List<Integer>> map;

    public int minJumps(int[] arr)
    {
        map = new HashMap<>();
        for(int i = 0; i < arr.length; i++)
        {
            int num = arr[i];
            List<Integer> temp;
            if(!map.containsKey(num))temp = new ArrayList<Integer>();
            else temp = map.get(num);
            temp.add(i);
            map.put(num, temp);
        }
        destination = arr.length - 1;
        dist = new int[arr.length];
        for(int i = 0; i < arr.length; i++)dist[i] = Integer.MAX_VALUE;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        dist[0] = 0;
        while(!q.isEmpty())
        {
            int curr = q.poll();
            int count = dist[curr];
            if(curr == destination)return count;
            List<Integer> temp = map.get(arr[curr]);

            for(int i : temp)
            {
                if(count + 1 < dist[i])
                {
                    dist[i] = count + 1;
                    q.offer(i);
                }
            }
            temp.clear();
            if(curr + 1 < arr.length && count + 1 < dist[curr + 1])
            {
                dist[curr + 1] = count + 1;
                q.offer(curr + 1);
            }
            if(curr - 1 >= 0 && count + 1 < dist[curr - 1])
            {
                dist[curr - 1] = count + 1;
                q.offer(curr - 1);
            }
        }
        return dist[arr.length - 1];
    }
}