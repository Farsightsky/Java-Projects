package hw3;

public class BananaQ<T>{
	private Node<T> front;							//variable declaration for queue
	private Node<T> rear;							//node for the front and the end of the queue
	private int length;								//size of the queue

	
	public void Enqueue(T data) {					//enqueue for adding elements at the rear
		Node<T> temp = new Node<T>(data);			//the data is temporarily stored at a temp node
		if(length == 0) {							//if length is 0, there is no element in the queue, which defaults the temp node
			front = temp;							//along with its data to be the front
		}
		else {
			rear.setNext(temp);						//the data is stored in a new position at the back of the queue
		}
		
		rear = temp;								//the rear node is updated and gets pointed at the new inserted data
		length++;									//the queue increases by 1
	}
	
	public Object Dequeue() {
		Object result = front.getData();			//dequeue for removing elements at the front
		if (length == 0) { 
			System.out.println("No queues.");		//if there's no queue
		}
		else if (length > 0) { 							
		front = front.getNext();					//takes the data stored at the front node and stores it in a new variable
		if(front == null) {							//takes the next node as the new front node
			rear = null;							//since nothing is pointed to it
		}
											
		}
		length--;									//the queue decreases by 1
		return result;								//returns the result, the data of the former first node
	}
	
	public void printQueue() {						//prints the queue
		if(length==0) {								//if queue is empty, returns nothing
			return;
		}
		
		Node<T> placeholder = front;					
		while(placeholder != null) {					//code repeats while there is still a node that points to the next
			System.out.print(placeholder.getData() + " >>> ");	//executes the printing of the queue
			placeholder = placeholder.getNext();			//updates the placeholder node, will continue until it reaches the rear
		}
		System.out.println("end");					//prints when the stack end
	}
	
	public int Length() {
		return this.length;						//returns the size of the queue
	}
}