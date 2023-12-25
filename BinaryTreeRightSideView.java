import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//this class defines the stucture of a binary tree node.
//Each node references to its left and right children.
//Each node has a value ('val')
class TreeNode {
    int val;
    TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
    }
}

//this class contain the method to find the right side view
//this method takes root of the binary tree as an argument and initalizes an empty list 'result' to sore the right side view.
//A queue is implemneted as a linked-list, the root of the binary tree is enqueued (added) to the queue
public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();     //create a quque
        queue.offer(root);                               // add the binary tree root node to the quque

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                // For each level, only add the rightmost node to the result
                if (i == size - 1) {
                    result.add(current.val);         //this is the right most node in the currrent tree level
                }                                    //therefore, add the node value to the result list

                if (current.left != null) {
                    queue.offer(current.left);        //add the next left child node to the queue
                }

                if (current.right != null) {
                    queue.offer(current.right);        //add the next right child node to the queue
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Example Usage:
        // Construct a binary tree
        //        1
        //       / \
        //      2   3
        //       \   \
        //        5   4
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        BinaryTreeRightSideView solution = new BinaryTreeRightSideView();
        List<Integer> result = solution.rightSideView(root);

        System.out.println("Right Side View: " + result);
    }
}
