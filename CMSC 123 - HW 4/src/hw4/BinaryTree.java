package hw4;

import java.io.PrintStream;

class BinaryTree<T> {
	Node<T> Root;
	Node<String> StringRoot;
	BinaryTree() {
		Root = null;
	}
	void printPostorder(Node<T> node) {
		if (node == null)
			return;
 
	// first recur on left subtree
		printPostorder(node.getLeft());
 
	// then recur on right subtree
		printPostorder(node.getRight());
 
	// now deal with the node
		System.out.print(node.getData() + " ");
	}

	// Given a binary tree, print its nodes in in-order
	void printInorder(Node<T> node) {
		if(node == null)
			return;
	
		// first recur on left child
		printInorder(node.getLeft());
	
		// then print the data of node
		System.out.print(node.getData() + " ");
	 
		// now recur on right child
		printInorder(node.getRight());
	}

	// Given a binary tree, print its nodes in pre-order
	void printPreorder(Node<T> node) {
		if (node == null)
			return;
		// first print data of node 
		System.out.print(node.getData() + " ");
	
		// then recur on left subtree
		printPreorder(node.getLeft());
	
		// now recur on right subtree
		printPreorder(node.getRight());
		}

	// Wrappers
	void printPostorder() {
		printPostorder(Root);
	}
	void printInorder() {
		printInorder(Root);
	}
	void printPreorder() {
		printPreorder(Root);
	}
	
	public Node<T> getRoot() {							//returns the root node
		return this.Root;
	}

	public void setRoot(Node<T> root) {					//updates the root node
		this.Root = root;
	}
	
	public String preOrder(Node<T> root) {
		//general case if root is empty
		if (root == null) {
			return "Root is null";
		}
		
		String cornerRight = "\u2514\u2500\u2500";
		String cornerLeft = (root.getRight() != null) ? "\u251c\u2500\u2500" : "\u2514\u2500\u2500";
		StringBuilder sb = new StringBuilder();
		sb.append(root.getData());

		traversePreONodes(sb, "", cornerLeft, root.getLeft(), root.getRight() != null);
		traversePreONodes(sb, "", cornerRight, root.getRight(), false);

		return sb.toString();
	}
	
	public void traversePreONodes(StringBuilder sb, String fill, String corner, Node<T> node, boolean rightChildExists) {
		if (node != null) {
			sb.append("\n");
			sb.append(fill);
			sb.append(corner);
			sb.append(node.getData());

			StringBuilder filler = new StringBuilder(fill);
				if (rightChildExists) {
					filler.append("\u2502  ");
				}
				else {
					filler.append("   ");
				}

			String fillBoth = filler.toString();			String cornerRight = "\u2514\u2500\u2500";
			String cornerLeft = (node.getRight() != null) ? "\u251c\u2500\u2500" : "\u2514\u2500\u2500";
			traversePreONodes(sb, fillBoth, cornerLeft, node.getLeft(), node.getRight() != null);
			traversePreONodes(sb, fillBoth, cornerRight, node.getRight(), false);
			}
	}
	
	public void displayBT(PrintStream ps) {
		ps.print(preOrder(getRoot()));
	}
	
	public void display() {
		displayBT(System.out);
	}
	
	public boolean isLeaf(Node<T> root) {
		return root.getLeft() == null && root.getRight() == null;
	}
	
	public double process(T t, double number1, double number2) {
		if (t.equals("+")) {
			return number1 + number2;
		}
		if (t.equals("-")) {
			return number1 - number2;
		}
		if (t.equals("*")) {
			return number1 * number2;
		}
		if (t.equals("/")) {
			return number1 / number2;
		}
		return 0;
	}
	public double evaluate(Node<T> root){
		// general case if root is empty
		if (root == null) {
			return 0;
		}
 
		// gets the double value of the String if node has left and right children
		if (isLeaf(root)) {
			return Double.valueOf((String) root.getData());
		}
 
		// recursive evaluation of the left subtree and the right subtree
		double number1 = evaluate(root.getLeft());
		double number2 = evaluate(root.getRight());
 
		// applying the operations from the gathered data from the previous instructions
		return process(root.getData(), number1, number2);
	}
	
	
	//wrapper
	public double eval() {
		return evaluate(Root);
	}
}

/*
Translated into the parameterized class
Source code: https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
*/
