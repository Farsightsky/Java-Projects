package solution;

class Graph{
	LinkedList<Integer>[] node;
	//creating list of list with index
	@SuppressWarnings("unchecked")
	Graph(int n) {
		node = new LinkedList[n];
		for (int i = 0; i < n; i++) {
			node[i] = new LinkedList<>();
		}
	}
	
	//topological sort
	public String topoSort() {
	char rbtry = 'a';
	Stack<Integer> letters = new Stack<>(); 					//stack for the letter values
		boolean[] visit = new boolean[node.length]; 			//visit booleans to keep track of the recursion visits
		for(int i = 0;i < node.length;i++) 						//set default to false on the boolean array visits
			visit[i] = false; 
		for(int i = 0;i < node.length;i++)
			if (!visit[i]) 
				topoRecur(i, visit, letters);					//if the node is unvisited, run the function
		String ans = "";
		while (!letters.isEmpty())								//do until stack is empty
			ans += (char)(rbtry + (int)(letters.Pop())); 		//pop elements of the stock while adding the arbitrary value
		return ans;
	}
	
	void topoRecur(int i, boolean[] visit, Stack<Integer> letters) {
		visit[i] = true;										//set the visit as true
		for (int j:node[i]) {									//loop for how many edges a character has to another character
			if(!visit[j]) {										//if a certain latter character is unvisited,
				topoRecur(j, visit, letters);					//run the topRecur function again for that value for re-checking of values
			}
		}
		letters.Push(i); 										//push the value of the character to the stack
	}
}