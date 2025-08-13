package solution;

public class Node<T> {
	private Node<T> Next;								//declaration of variables
	private T Data;										//the data associated with the nodes
	public Node() {										//initially set to null to indicate empty
		this.Data = null;
		this.Next = null;
	}
	
	public Node(T data) {								//the data is stored
		this.Data = data;
	}
	
	public T getData() {								//the data is returned
		return this.Data;
	}
	
	public void setData(T data) {						//the data is updated
		this.Data = data;
	}

	public Node<T> getNext() {							//returns the node
		return this.Next;
	}

	public void setNext(Node<T> next) {					//updates the node
		this.Next = next;
	}
}
