package solution;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T>{	//need to
	private Node<T> Head, Tail;						//first and last node
	private int length = 0;							//length of list
	
	LinkedList() {
		this.Head = null;							//initialization of the constructor
	}
	void add(T data) {								//adding data
		Node<T> Item = new Node<>(data);
		if (this.Head == null) {
			Tail = Head = Item;						//Head is tail if there is no elements yet
		}
		else {										//set the next node with the data
			Tail.setNext(Item);
			Tail = Item;							//set the current data node as the tail
		}
		length++;									//increments the length by 1
	}
	
	int getLength() {								//return the size/length of the list.
		return this.length;
	}
	
	void clear(){									//emptying the list
		Head = null;
		length = 0;
	}
	
	public Node<T> getHead() {						//return the head node
		return Head;
	}
	
	public Iterator<T> iterator() {					//To iterate the linkedlist on a for-each loop since it would not be iterable without this.
		return new LinkedListIterator<T>(this);
	}
}
