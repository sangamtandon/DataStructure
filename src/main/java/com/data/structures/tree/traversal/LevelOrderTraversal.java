/*Time Complexity: O(n^2) in worst case. 
 *For a skewed tree, printGivenLevel() takes O(n) time where n is the number of nodes in the skewed tree. 
 *So time complexity of printLevelOrder() is O(n) + O(n-1) + O(n-2) + .. + O(1) which is O(n^2).
 *Space Complexity: O(n) in worst case. 
 *For a skewed tree, printGivenLevel() uses O(n) space for call stack. 
 *For a Balanced tree, call stack uses O(log n) space, (i.e., height of the balanced tree).
 */

package com.data.structures.tree.traversal;

import java.util.LinkedList;
import java.util.Queue;

import com.data.structures.tree.BinaryTree;
import com.data.structures.tree.BinaryTreeHeight;
import com.data.structures.tree.Node;

public class LevelOrderTraversal {

	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.root = new Node(1);
		binaryTree.root.left = new Node(2);
		binaryTree.root.right = new Node(3);
		binaryTree.root.left.left = new Node(4);
		binaryTree.root.left.right = new Node(5);
		binaryTree.root.left.left.right = new Node(6);
		printLevelOrder(binaryTree);
		//printLevelOrderusingQueue(binaryTree);
	}

	public static void printLevelOrder(BinaryTree binaryTree) {
		int height = BinaryTreeHeight.getBinaryTreeHeight(binaryTree);
		for (int i = 0; i <= height; i++) {
			printGivenLevel(binaryTree.root, i);
		}
	}

	private static void printGivenLevel(Node root, int level) {
		if (root == null) {
			return;
		}
		if (level == 0) {
			System.out.println(root.data + " ");
		}
		else if (level > 0) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}
	
	public static void printLevelOrderUsingQueue(BinaryTree binaryTree) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(binaryTree.root);
		while (!queue.isEmpty()) {
			Node tempNode = queue.poll();
			System.out.print(tempNode.data + " ");
			
			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}
			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}
		}
	}

}
