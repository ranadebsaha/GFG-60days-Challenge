//Vertical Tree Traversal
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() { return key; }

    public V getValue() { return value; }
}

class Solution {
    public ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
        // code here
        Map<Integer, ArrayList<Integer>> lst = new HashMap<>();
        Queue<Pair<Node, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(root, 0));

        int mn = 0, mx = 0;

        while (!q.isEmpty()) {
            Pair<Node, Integer> c = q.poll();
            mn = Math.min(mn, c.getValue());
            mx = Math.max(mx, c.getValue());
            lst.putIfAbsent(c.getValue(), new ArrayList<>());
            lst.get(c.getValue()).add(c.getKey().data);

            if (c.getKey().left != null)
                q.offer(new Pair<>(c.getKey().left, c.getValue() - 1));

            if (c.getKey().right != null)
                q.offer(new Pair<>(c.getKey().right, c.getValue() + 1));
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = mn; i <= mx; i++)
            res.add(lst.get(i));

        return res;
    }
}
