class Solution {
    public void sorting(List<List<String>> events)
    {
        events.sort((a, b) -> {

        int valA = Integer.parseInt(a.get(1));
        int valB = Integer.parseInt(b.get(1));

        if (valA != valB) {
            return Integer.compare(valA, valB);
        }

        char cA = a.get(0).charAt(0);
        char cB = b.get(0).charAt(0);

        if (cA == 'O' && cB != 'O') return -1;  
        if (cA != 'O' && cB == 'O') return 1;   

        return 0;
        });
    }
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        sorting(events);
        int result[] = new int[numberOfUsers];
        int status[] = new int[numberOfUsers];
        int all=0;
        for(int i=0;i<events.size();i++)
        {
            List<String> curr = events.get(i);
            char ch = curr.get(0).charAt(0);
            int time_stamp = Integer.parseInt(curr.get(1));
            String mention = curr.get(2);
            if(ch == 'M')
            {
                char m = mention.charAt(0);
                if(m == 'A')all++;
                else if(m == 'H')
                {
                    for(int j=0;j<numberOfUsers;j++)
                    {
                        if(status[j] == 0)result[j]++;
                        else if(time_stamp - status[j]>=60)
                        {
                            status[j]=0;
                            result[j]++;
                        }
                    }
                }
                else
                {
                    String str[] = mention.split(" ");
                    for(int j=0;j<str.length;j++)
                    {
                        int id = Integer.parseInt(str[j].substring(2));
                        result[id]++;
                    }
                }
            }
            else
            {
                status[Integer.parseInt(mention)] = time_stamp;
            } 
        }
        if(all != 0)
        {
            for(int i=0;i<numberOfUsers;i++)
            {
                result[i] += all;
            }
        }
        return result;
    }
}