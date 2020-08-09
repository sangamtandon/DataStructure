package com.data.structures.tree;

public class BinaryTree {
	
	public Node root;
	
	public BinaryTree() {
		root = null;
	}
	
	public BinaryTree(int value) {
		root = new Node(value);
	}
	
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.root = new Node(5);
		binaryTree.root.left = new Node(1);
		binaryTree.root.right = new Node(4);
		binaryTree.root.left.left = new Node(3);
		System.out.println("PreOrder Traversal:");
		BinaryTree.printPreOrder(binaryTree);
		System.out.println("\nInOrder Traversal:");
		BinaryTree.printInOrder(binaryTree);
		System.out.println("\nPostOrder Traversal:");
		BinaryTree.printPostOrder(binaryTree);
		
	}
	
	public static void printPreOrder(BinaryTree binaryTree) {
		printPreOrder(binaryTree.root);
	}
	public static void printInOrder(BinaryTree binaryTree) {
		printInOrder(binaryTree.root);
	}
	public static void printPostOrder(BinaryTree binaryTree) {
		printPostOrder(binaryTree.root);
	}
	
	public static void printPreOrder(Node node) {
		if(node == null) {
			return;
		}
		
		System.out.print(node.data + " ");
		printPreOrder(node.left);
		printPreOrder(node.right);
		
	}
	
	public static void printInOrder(Node node) {
		if(node == null) {
			return;
		}
		
		printInOrder(node.left);
		System.out.print(node.data + " ");
		printInOrder(node.right);
		
	}
	
	public static void printPostOrder(Node node) {
		if(node == null) {
			return;
		}

		printPostOrder(node.left);
		printPostOrder(node.right);
		System.out.print(node.data + " ");
		
	}

}
