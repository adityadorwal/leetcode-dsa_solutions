class Solution {
public:
    int countPalindromicSubsequence(string s) {
        int n = s.size();
        vector<int> first(26, -1); // First occurrence of each character
        vector<int> last(26, -1);  // Last occurrence of each character

        // Step 1: Record the first and last occurrences of each character
        for (int i = 0; i < n; ++i) {
            if (first[s[i] - 'a'] == -1) {
                first[s[i] - 'a'] = i;
            }
            last[s[i] - 'a'] = i;
        }

        // Step 2: Count unique palindromic subsequences
        int count = 0;
        for (int i = 0; i < 26; ++i) {
            if (first[i] != -1 && last[i] > first[i]) {
                // Character `i` can be the first and last character of a palindrome
                set<char> middleChars;
                for (int j = first[i] + 1; j < last[i]; ++j) {
                    middleChars.insert(s[j]);
                }
                count += middleChars.size(); // Count unique middle characters
            }
        }

        return count;
    }
};