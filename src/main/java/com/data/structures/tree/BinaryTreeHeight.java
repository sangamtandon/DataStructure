package com.data.structures.tree;

public class BinaryTreeHeight {

	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.root = new Node(0);
		binaryTree.root.left = new Node(1);
		binaryTree.root.right = new Node(2);
		binaryTree.root.left.left = new Node(3);
		binaryTree.root.left.left.left = new Node(4);
		binaryTree.root.left.left.right = new Node(5);
		System.out.println(getBinaryTreeHeight(binaryTree));
	}
	
	public static int getBinaryTreeHeight(BinaryTree binaryTree) {
		return getHeight(binaryTree.root);
	}
	
	private static int getHeight(Node root) {
		if(root == null)
			return -1;
		
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		
		return 1 + Math.max(leftHeight, rightHeight);
	}

}
