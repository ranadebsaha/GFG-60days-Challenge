//Huffman Encoding

class Node {
    int data;
    int index;
    Node left, right;

    Node(int data, int index) {
        this.data = data;
        this.index = index;
        this.left = null;
        this.right = null;
    }

    Node(Node left, Node right) {
        this.data = left.data + right.data;
        this.index = Math.min(left.index, right.index);
        this.left = left;
        this.right = right;
    }
}

class Compare implements Comparator<Node> {
    public int compare(Node a, Node b) {
        if (a.data == b.data) {
            return a.index - b.index;
        }
        return a.data - b.data;
    }
}

class Solution {
    public ArrayList<String> huffmanCodes(String s, int f[]) {
        int n = s.length();
        PriorityQueue<Node> pq = new PriorityQueue<>(new Compare());
        
        for (int i = 0; i < n; i++) {
            pq.add(new Node(f[i], i));
        }

        if (n == 1) {
            ArrayList<String> res = new ArrayList<>();
            res.add("0");
            return res;
        }

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            
            Node newNode = new Node(left, right);
            pq.add(newNode);
        }

        Node root = pq.poll();
        ArrayList<String> ans = new ArrayList<>();
        preOrder(root, "", ans);
        
        return ans;
    }
    
    private void preOrder(Node root, String curr, ArrayList<String> ans) {
        if (root == null) return;
        
        if (root.left == null && root.right == null) {
            ans.add(curr);
            return;
        }
        
        preOrder(root.left, curr + "0", ans);
        preOrder(root.right, curr + "1", ans);
    }
}
