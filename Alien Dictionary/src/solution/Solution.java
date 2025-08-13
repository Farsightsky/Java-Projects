package solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class GFG3 {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0) {
			int n = Integer.parseInt(sc.next());
			int k = Integer.parseInt(sc.next());
			
			String[] words = new String[n];
			
			for(int i=0;i<n;i++) {
				words[i] = sc.next();
			}
			Solution ob = new Solution();
			//  System.out.println(T.findOrder(words,k));
			String order = ob.findOrder(words,n,k);
			if(order.length() == 0){
				System.out.println(0);
				continue;
			}
			String temp[] = new String[n];
			for(int i=0;i<n;i++)
				temp[i] = words[i];
			
			Arrays.sort(temp, new Comparator<String>(){
				
			@Override
			public int compare(String a, String b) {
				int index1 = 0;
				int index2 = 0;
				for(int i = 0; i < Math.min(a.length(), b.length()) && index1 == index2; i++) {
					index1 = order.indexOf(a.charAt(i));
					index2 = order.indexOf(b.charAt(i));
				}

				if(index1 == index2 && a.length() != b.length()) {
					if(a.length() < b.length())
						return -1;
					else
						return 1;
				}

				if(index1 < index2)
					return -1;
				else
					return 1;

			}
		});

			int flag = 1;
			for(int i=0;i<n;i++){
				if(!words[i].equals(temp[i])) {
					flag = 0;
					break;
				}
			}
			System.out.println(flag);
			System.out.println(order);
		}
	}	
}

class Solution {
	public String findOrder(String [] dict, int N, int K) {
		//allocation of memory
		Graph g = new Graph(K);
		//arbitrary value for reference
		char rbtry = 'a';
		//loop N-1 since i starts with 0
		for (int i = 0; i < N - 1; i++) {	
			//find the minimum character count of two
			int len = Math.min(dict[i].length(), dict[i+1].length());
			//loop for the smaller character count for each string
			for(int j = 0;j < len;j++) { 
				/*if the adjacent characters are not equal, then add a unidirectional edge to the former character*/
				if(dict[i].charAt(j) != dict[i+1].charAt(j)) {
					g.node[dict[i].charAt(j) - rbtry].add(dict[i+1].charAt(j)- rbtry); 
					break; 
				} 
			}
		}
		String res = g.topoSort();
		return res;
	}
}

/*
demo these
1
5 4
baa abcd abca cab cada

ba
da
ac
bd


1
6 5
eac cab bad bdc abc adc

1
3 3
bac aac abc
//non-consecutive letter
1
3 4
ace bae bac
//no a
1
5 4
cbb bcde bcdb dbc dbeb
 */