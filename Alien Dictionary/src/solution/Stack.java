package solution;

public class Stack<T> {
	private Node<T> top;							//declaration of variables, node top to point at the top of the linked list
	private int length;	
	public Stack() {
		top = null;									//initialization of variable, top isn't pointing to any data yet
		length = 0;									//initially 0 for an empty stack
	}
	
	public void Push(T data) {						//inserts a data at the top of the linked list
		Node<T> temp = new Node<T>(data);			//data is temporarily stored at a temp node
		temp.setNext(top);							//the temp node becomes the new top node ******************
		top = temp;									//top node is updated with the temp node
		length++;									//stack length increases by 1
	}
	
	public Object Pop() {							//deletes the recent data inserted at the top
		Object deleteTop = top.getData();			//stores the data about to be deleted in a new object****************
		top = top.getNext();						//the top node moves next down the stack and updates the new top node**************
		length--;									//stack length decreases by 1
		return deleteTop;							//returns the deleted value
	}
	
	public Object Peek() {							//returns the data at the top of the stack
		return top.getData();
	}
	public int getLength() {						//returns the size of the stack
		return this.length;
	}
	
	boolean isEmpty() {
		if(length==0) {
			return true;
		}
		return false;
	}
}