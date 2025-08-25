// class Solution {
//     public int countStudents(int[] students, int[] sandwiches) {
//         Deque<Integer> que = new ArrayDeque<>();
//         for(int i: students)que.offer(i);
//         int k=0;
//         while(!que.isEmpty())
//         {
//             int len = que.size();
//             for(int i=0; i<len ; i++)
//             {
//                 if(que.peek()==sandwiches[k])
//                 {
//                     que.pop();
//                     k++;
//                 }
//                 else que.offer(que.pop());
//             }
//             int curr_size = que.size();
//             if(curr_size ==len)return curr_size;
//         }
//         return 0;
//     }
// }


class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int count0 = 0, count1 = 0;

        for (int s : students) {
            if (s == 0) count0++;
            else count1++;
        }

        for (int sandwich : sandwiches) {
            if (sandwich == 0)
            {
                if (count0 == 0) break; 
                count0--;
            } 
            else
            {
                if (count1 == 0) break; 
                count1--;
            }
        }
        // Remaining students
        return count0 + count1;
    }
}
