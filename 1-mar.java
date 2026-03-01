//Move All Zeroes to End
class Solution {
    void pushZerosToEnd(int[] arr) {
        // code here
        int left=0,right=0;
        for(int i=0; i<arr.length;i++){
            if(arr[i]!=0){
                int temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
                left++;
                right++;
            }else if(arr[i]==0){
                right++;
            }
        }
    }
}
