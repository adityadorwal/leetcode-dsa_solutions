// class Solution {
//     public int compareVersion(String version1, String version2) {
//         String []n = version1.split("\\.");
//         String []m = version2.split("\\.");
//         int n_len = n.length , m_len = m.length;
//         for(int i=0;i<Math.max(n_len,m_len);i++)
//         {
//             int num1 = (i<n_len)?Integer.parseInt(n[i]):0 , num2 = (i<m_len)?Integer.parseInt(m[i]):0;
//             if(num1<num2)return -1;
//             if(num1>num2)return 1;
//         }
//         return 0;
//     }
// }

class Solution {
    public int compareVersion(String version1, String version2) {
        int i = 0, j = 0;
        int n = version1.length(), m = version2.length();

        while (i < n || j < m) {
            int num1 = 0, num2 = 0;

            // Parse number from version1 until '.' or end
            while (i < n && version1.charAt(i) != '.') {
                num1 = num1 * 10 + (version1.charAt(i) - '0');
                i++;
            }

            // Parse number from version2 until '.' or end
            while (j < m && version2.charAt(j) != '.') {
                num2 = num2 * 10 + (version2.charAt(j) - '0');
                j++;
            }

            if (num1 < num2) return -1;
            if (num1 > num2) return 1;

            // Skip the '.' in both versions
            i++;
            j++;
        }
        return 0;
    }
}
