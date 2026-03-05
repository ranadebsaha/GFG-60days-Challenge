//Longest Substring with K Uniques
class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int n = s.length();
        int i = 0, j = 0;
        int cnt = 0;
        int maxi = -1;
        int[] fre = new int[26];
        
        while (j < n) {

            fre[s.charAt(j) - 'a']++;
            if (fre[s.charAt(j) - 'a'] == 1) cnt++;
            while (cnt > k) {
                fre[s.charAt(i) - 'a']--;
                if (fre[s.charAt(i) - 'a'] == 0) cnt--;
                i++;
            }
            if (cnt == k) {
                maxi = Math.max(maxi, j - i + 1);
            }

            j++;
        }

        return maxi;
    }
}
