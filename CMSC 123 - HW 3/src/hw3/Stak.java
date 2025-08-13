package hw3;
public class Stak<T> {
	private Node<T> top;							//declaration of variables, node top to point at the top of the linked list
	private int length;								//length of the stack

	public Stak() {
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

	public void printStack() {						//prints the stack
		if(length==0) {
			System.out.println("No data");			//if the stack has no data
		}
		
		Node<T> placeholder = top;
		while(placeholder != null) {							//code repeats while there is still a node that points to the next
			System.out.print(placeholder.getData() + " >> ");	//executes the printing of the stack
			placeholder = placeholder.getNext();				//updates the placeholder node, will continue until it reaches the bottom
		}														//which is the first data inserted
		System.out.println("end");								
	}
	
	public int Length() {							//returns the size of the stack
		return this.length;
	}
}
