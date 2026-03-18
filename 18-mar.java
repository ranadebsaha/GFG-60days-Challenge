//Distribute Candies
import java.util.Stack;

class Pair<K, V> {

    private K key;
    private V value;
  
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }
}


class Solution {
    
    public int distCandy(Node root) {
        // code here
        
        if (root == null) return 0;
        int ans = 0;

        Stack<Pair<Node, Integer>> stk = new Stack<>();

        HashMap<Node, Integer> balance = new HashMap<>();

        stk.push(new Pair<>(root, 0));

        while (!stk.isEmpty()) {

            Pair<Node, Integer> curr = stk.pop();
            Node node = curr.getKey();
            int state = curr.getValue();

            if (node == null) continue;

            if (state == 0) {

                stk.push(new Pair<>(node, 1));

                stk.push(new Pair<>(node.left, 0));

                stk.push(new Pair<>(node.right, 0));

            } 
            else {

                int leftBalance 
                         = balance.getOrDefault(node.left, 0);

                int rightBalance 
                         = balance.getOrDefault(node.right, 0);

                ans += Math.abs(leftBalance) 
                            + Math.abs(rightBalance);

                balance.put(node, node.data 
                            + leftBalance + rightBalance - 1);
            }
        }

        return ans;
    }
}
