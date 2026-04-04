//Gray Code
class Solution {
    public ArrayList<String> graycode(int n) {
        // code here
        ArrayList<String> res = new ArrayList<>();

        for (int i = 0; i < (1 << n); i++) {
          
            int g = i ^ (i >> 1);

            StringBuilder sb = new StringBuilder();
            for (int j = n - 1; j >= 0; j--) {
                if ((g & (1 << j)) != 0)
                    sb.append('1');
                else
                    sb.append('0');
            }

            res.add(sb.toString());
        }

        return res;
    }
}
