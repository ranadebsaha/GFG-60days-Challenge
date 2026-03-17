//Burning Tree
class Solution {
    public int minTime(Node root, int target) {
        // code here
        Map<Integer, Node> parent = new HashMap<>();
        setParent(root, parent);

        Node targetNode = findTarget(root, target);
        Map<Integer, Boolean> visited = new HashMap<>();

        return dfs(targetNode, visited, parent) - 1;
    }
    static void setParent(Node root, Map<Integer, Node> parent) {
        if (root == null) return;
        if (root.left != null) {
            parent.put(root.left.data, root);
            setParent(root.left, parent);
        }
        if (root.right != null) {
            parent.put(root.right.data, root);
            setParent(root.right, parent);
        }
    }

    static Node findTarget(Node root, int target) {
        if (root == null) return null;
        if (root.data == target) return root;
        Node left = findTarget(root.left, target);
        if (left != null) return left;
        return findTarget(root.right, target);
    }
    static int dfs(Node node, Map<Integer, Boolean> visited, Map<Integer, Node> parent) {
        if (node == null || visited.getOrDefault(node.data, false)) return 0;
        visited.put(node.data, true);

        int left = dfs(node.left, visited, parent);
        int right = dfs(node.right, visited, parent);

        int parTime = parent.containsKey(node.data) ? dfs(parent.get(node.data), visited, parent) : 0;

        return Math.max(Math.max(left, right), parTime) + 1;
    }
}
