package hw4;

public class Node<T> {
	T Data;
	Node<T> Left, Right;
	
	Node(){
		this.Data = null;
	}
	
	Node(T data) {										//the data is stored
		this.Data = data;
		Left = Right = null;							//would return null for left and right child nodes
	}
	
	public T getData() {								//the data is returned
		return this.Data;
	}
	
	public void setData(T data) {						//the data is updated
		this.Data = data;
	}
	
	public Node<T> getLeft() {							//returns the left node
		return this.Left;
	}

	public void setLeft(Node<T> left) {					//updates the left node
		this.Left = left;
	}
	
	public Node<T> getRight() {							//returns the right node
		return this.Right;
	}

	public void setRight(Node<T> right) {				//updates the right node
		this.Right = right;
	}
}
