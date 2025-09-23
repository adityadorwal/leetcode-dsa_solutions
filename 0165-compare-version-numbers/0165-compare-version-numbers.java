class Solution {
    public int compareVersion(String version1, String version2) {
        String []n = version1.split("\\.");
        String []m = version2.split("\\.");
        int n_len = n.length , m_len = m.length;
        for(int i=0;i<Math.max(n_len,m_len);i++)
        {
            int num1 = (i<n_len)?Integer.parseInt(n[i]):0 , num2 = (i<m_len)?Integer.parseInt(m[i]):0;
            if(num1<num2)return -1;
            if(num1>num2)return 1;
        }
        return 0;
    }
}