//Subarrays with First Element Minimum
class Solution {
    public int countSubarrays(int[] arr) {
        // code here
        Stack<Integer> st = new Stack<Integer>();
    int ans = 0;
    int n = arr.length;
    for (int i = n - 1; i >= 0; i--) {
      while (st.empty() == false
             && arr[st.peek()] >= arr[i])
        st.pop();
      int last = ((st.empty() == true) ? n : st.peek());
      ans += (last - i);
      st.push(i);
    }
    return ans;
    }
}
