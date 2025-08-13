package hw4;

public class BinaryTreeMain {
	public static void main (String[] args) {
		BinaryTree<String> tree = new BinaryTree<String> ();
		tree.setRoot(new Node<String> ("+"));
		Node<String> node1 = new Node<String>("-");
		Node<String> node2 = new Node<String>("2");
		tree.getRoot().setLeft(node1);
		tree.getRoot().setRight(node2);
		node1.setLeft(new Node<String>("3"));
		node1.setRight(new Node<String>("4"));
 
		tree.printPostorder();
		System.out.println();
		tree.display();
		
		System.out.println();
		System.out.println("The value of the expression tree is "+ tree.eval());
	}
}