import java.util.Arrays;
import java.util.Collections;
	import java.util.PriorityQueue;
import java.util.Scanner;

class GFG5 {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int n;
		while(t-- > 0){
			n = sc.nextInt();
			Solution obj = new Solution();
			for(int i = 1; i <= n; i++) {
				int x =sc.nextInt();
				obj.insertHeap(x);
				System.out.println((int)Math.floor(obj.getMedian()));
			}
		}
	}
}



class Solution {
	static PriorityQueue<Integer> low = new PriorityQueue<>(Collections.reverseOrder());		//arranges the value in the reverse fashion
	static PriorityQueue<Integer> high = new PriorityQueue<>();

	public static void insertHeap(int x) {
		if(low.isEmpty())										//If low PQueue is empty, add the current num to the low
			low.add(x);
		else if(x > low.peek())									//If current num is higher than the largest/head num of low PQueue, add num to the high
			high.add(x);
		else if(high.isEmpty())									//If high is empty, then add it to low
			high.add(low.peek());
		else low.add(x);
		if(Math.abs(low.size()-high.size()) > 1) {				//if one PQueue is larger than 2 or more than the other PQueue, balance the heap
			balanceHeaps();
		}
	}

	public static void balanceHeaps() {
		if (low.size() > high.size()) {
			high.add(low.peek());								//adding the highest/head number
			low.poll();											//deleting the current highest/head number of low
			}
		else
		{
			low.add(high.peek());								//adding the lowest/head number
			high.poll();										//deleting the current lowest/head number of high
		}
	}

	//Function to return Median.
	public static double getMedian() {
		System.out.println("lowPQ - "+Arrays.toString(low.toArray()));
		System.out.println("highPQ - " +Arrays.toString(high.toArray()));
		double med = 0.0; 									//initialize variable
		if (((low.size() + high.size()) & 1) == 0) {			//if combined size is even, bitwise
			med = (low.peek() + high.peek())/2;				//add the heads of both PQueue and half it
		}
		else {
			if (high.size() > low.size())
				med = high.peek();							//if high size is higher than low size, then show head/lowest num of high
			else if (high.size() < low.size())
				med = low.peek();							//if low size is higher than high size, then show head/highest num of low
			else
				med = low.peek();							//default case
		}
		return med;
	}
}

/*
demo this
1
4
5
15
1
3
 */