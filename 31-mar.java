//Buy Stock with Transaction Fee
class Solution {
    public int maxProfit(int arr[], int k) {
        // Code here
        int n = arr.length;

        int noStock = 0, inHand = 0;

        for (int i = n - 1; i >= 0; i--) {

            int newNoStock = Math.max(noStock, inHand - arr[i]);

            int newInHand = Math.max(inHand, arr[i] - k + noStock);
            noStock = newNoStock;
            inHand = newInHand;
        }

        return noStock;
    }
}
