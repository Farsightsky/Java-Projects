package solution;

import java.util.Iterator;

public class LinkedListIterator<T> implements Iterator<T> {
	Node<T> Check;
	public LinkedListIterator(LinkedList<T> list) {				// initialization of pointer to head node for iteration
		Check = list.getHead();
	}

	public boolean hasNext() {									// returns false if next element does not exist
		return Check != null;
	}

	public T next() {											// update and return check data with the next Node
		T data = Check.getData();
		Check = Check.getNext();
		return data;
	}
}
