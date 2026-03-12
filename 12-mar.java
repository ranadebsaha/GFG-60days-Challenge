//Minimum K Consecutive Bit Flips
class Solution {
    public int kBitFlips(int[] arr, int k) {
        // code here
       int n = arr.length; 
        int res = 0, flag = 0;
        Queue<Integer> q = new LinkedList<>(); 

        for (int i =0;i<n;i++) {
            
            if(i >= k)
                flag ^= q.poll();
            if(flag == 1)
                arr[i] ^=1;
            if(arr[i] == 0) {
                if(i +k > n) 
                    return -1;
                res +=1;
                flag ^=1;
                q.offer(1);
            }
            else {
                q.offer(0);
            }
        }

        return res; 
    }
}
