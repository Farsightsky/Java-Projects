package hw3;

public class StacknQueue {
	public static void main (String[] args) {
		System.out.println("Stack");
		System.out.println();
		System.out.println();
		Stak<String> stak = new Stak<String>();
		
		stak.Push("c");
		stak.Push("a");
		stak.Push("d");
		stak.Push("b");
		
		stak.printStack();
		
		stak.Pop();
		stak.printStack();
	}
}
