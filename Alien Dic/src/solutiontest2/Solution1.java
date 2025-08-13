package solutiontest2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class GFG {
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
		}
	}
}

class Solution {
	public String findOrder(String [] dict, int n, int m) {
		//creating map for connection who came before and after
		//use hashset to avoid duplicates, since there are a lot of comparisons
		HashMap<Character, HashSet<Character>> map = new HashMap<>();
		//calculating indegree of each sorted characters
		HashMap<Character,Integer> indegree = new HashMap<>();
		//logic for getting the indegree
		for(String str : dict) {
			//String to character conversion
			for(char ch : str.toCharArray()) {
				//initially adding the indegree as zero
				indegree.put(ch,0);
			}
		}
		//rather than comparing all the combinations we can check only two consecutive
		for(int i = 0; i < n-1 ; i++) {
			//get the first and sec string
			String curr = dict[i];
			String next = dict[i+1];
			//getting the minimum size of two consecutive strings
			int len = Math.min(curr.length(), next.length());
			//there is edge case we have to handle it
			boolean flag = false;
			for(int j = 0 ; j < len ; j++){
				//get those character
				char ch1 = curr.charAt(j);
				char ch2 = next.charAt(j);
				//compare them if not same who ever is first in dictionary will come first
				//this case ch1 come first
				if(ch1 != ch2 ) {
					HashSet<Character> set = new HashSet<>();
					if(map.containsKey(ch1) == true) {
						set = map.get(ch1);
						if(set.contains(ch2) == false) {
							//add that as set 
							set.add(ch2);
							//update their indegree
							indegree.put(ch2, indegree.get(ch2) + 1);
							//setting ch1 come first before ch2
							map.put(ch1, set);
						}
					}
					else {
						//if not present add them in set
						set.add(ch2);
						//connect ch1 to ch2
						map.put(ch1, set);
						//update the indegree
						indegree.put(ch2, indegree.get(ch2) + 1);
					}
					flag=true;
					break;
				}
			}
			//if two word are same, hence flag still false
			//and first length is greater than the next one means input given wrong
			if(flag ==false && curr.length() > next.length()) {
				return "";
			}
		}
		//use topological sorting/kahn's algorithm logic
		Queue<Character> qu = new LinkedList<>();
		StringBuilder ans = new StringBuilder();
		for(char ch : indegree.keySet()) {
			if(indegree.get(ch) == 0)
				qu.offer(ch);
			}
		int count = 0;
		while(qu.size() > 0 ) {
			char rem = qu.poll();
			count++;
			ans.append(rem);
			if(map.containsKey(rem) == true) {
				HashSet<Character> nbrs = map.get(rem);
				for(char nbr : nbrs) {
					indegree.put(nbr, indegree.get(nbr) - 1);
					if(indegree.get(nbr) == 0) {
						qu.offer(nbr);
					}
				}
			}
		}
		if(count == indegree.size())
			return ans.toString();
		else
			return "";
	}
}