//Generate IP Addresses
class Solution {
    public ArrayList<String> generateIp(String s) {
        // code here
        ArrayList<String> res = new ArrayList<>();
        generateIpRec(s, 0, "", 0, res);
        return res;
    }
    
    static boolean isValid(String s) {
        if (s.length() > 1 && s.charAt(0) == '0')
            return false;

        int val = Integer.parseInt(s);
        return val <= 255;
    }

    static void generateIpRec(String s, int index, String curr, int cnt, List<String> res) {

        if (index >= s.length())
            return;
        if (cnt == 3) {
            String last = s.substring(index);
            if (last.length() <= 3 && isValid(last))
                res.add(curr + last);
            return;
        }
        String segment = "";
        for (int i = index; i < Math.min(index + 3, s.length()); i++) {
            segment += s.charAt(i);

            if (isValid(segment))
                generateIpRec(s, i + 1, curr + segment + ".", cnt + 1, res);
        }
    }

}

