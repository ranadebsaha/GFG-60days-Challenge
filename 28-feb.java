//Find the closest pair from two arrays
class Solution {
    public static ArrayList<Integer> findClosestPair(int arr1[], int arr2[], int x) {
        // code here
        int com=Integer.MAX_VALUE,x1=0,x2=0;
        int left=0;
        int right=arr2.length-1;
        while(left<arr1.length && right>=0){
            int cursum=arr1[left]+arr2[right];
            int diff=Math.abs(x-cursum);
            if(com>diff){
                com=diff;
                x1=arr1[left];
                x2=arr2[right];
            }
            if(cursum==x){
                break;
            }
            else if(cursum<x){
                left++;
            }
            else{
                right--;
            }
        }
        
        
        ArrayList<Integer> pair =new ArrayList<>();
        pair.add(x1);
        pair.add(x2);
        return pair;
    }
}
