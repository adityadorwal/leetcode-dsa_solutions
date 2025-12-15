/*******************************MAth Based Approch*********** */

class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int count = 0;
        for(int i = 0; i < tickets.length; i++)
        {
            if(i<=k) count += Math.min(tickets[k],tickets[i]);
            else count += Math.min(tickets[k]-1,tickets[i]);
        }
        return count;
    }
}

/************************Queue based approch ***************** */
// class Solution {
//     public int timeRequiredToBuy(int[] tickets, int k) {
//         Queue<Integer> que = new LinkedList<>();
//         int count=0;
//         for(count=0 ; count< tickets.length ; count++)
//         {
//             int num = tickets[count];
//             if(k==count && num==1)return count+1;
//             if(num-1 != 0)que.offer(count);
//             tickets[count] = num-1;
//         }
//         while(!que.isEmpty())
//         {
//             count++;
//             int ind = que.poll();
//             int num = tickets[ind]-1;
//             if( num == 0 && k==ind)return count;
//             if(num != 0)que.offer(ind);
//             tickets[ind] = num;
//         }
//         return 0;
//     }
// }