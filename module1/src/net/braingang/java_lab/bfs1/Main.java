package net.braingang.java_lab.bfs1;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class Node {
    int key;
    Node left, right;

    public Node(int arg) {
        key = arg;
        left = null;
        right = null;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(Integer.toString(key));

        if (left == null) {
            sb.append(" left:null");
        } else {
            sb.append(" left:" + Integer.toString(left.key));
        }

        if (right == null) {
            sb.append(" right:null");
        } else {
            sb.append(" right:" + Integer.toString(right.key));
        }

        return sb.toString();
    }
}

public class Main {

    public Main() {
        System.out.println("ctor");
    }

    Node insert(Node root, int candidate) {
        Node element = new Node(candidate);

        if (root == null) {
            return element;
        }

        Node current = root;

        while (true) {
            if (element.key < current.key) {
                if (current.left == null) {
                    current.left = element;
                    return root;
                } else {
                    current = current.left;
                }
            } else {
                if (current.right == null) {
                    current.right = element;
                    return root;
                } else {
                    current = current.right;
                }
            }
        }
    }

    Node buildTree(int[] candidates) {
        Node root = null;

        for (int current:candidates) {
            System.out.println(current);
            root = insert(root, current);
        }

        return root;
    }

    void inOrder(Node root) {
        // returns sorted key
        // left, root, right
        if (root != null) {
            inOrder(root.left);
            System.out.println(root);
            inOrder(root.right);
        }
    }

    Queue<Node> queue = new LinkedList<Node>();

    void dfs(Node root) {
        queue.clear();
        queue.offer(root);

        System.out.println("-x-x-x-x-x-x-");
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println(node);

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("begin");

        Random random = new Random();

        int[] candidates = new int[10];

        for (int ii = 0; ii < candidates.length; ii++) {
            candidates[ii] = random.nextInt(1000);
            System.out.println(ii + ":" + candidates[ii]);
//            candidates[ii] = ii;
        }

        Main main = new Main();
        Node root = main.buildTree(candidates);
        main.dfs(root);

        System.out.println("end");
    }
}