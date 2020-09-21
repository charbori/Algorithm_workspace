package Algorithm.DFS_BFS.Work1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class BFSexam {
	
	private static LinkedList<Integer> visited;
	private static LinkedList<Integer> need_visit;
	private static HashMap <Integer, ArrayList<Integer>> graph;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * ������ �׷����� ������ Ž���ϴ� BFS�� ������
		 * 
		 */
		
		visited = new LinkedList<>();
		need_visit = new LinkedList<>();
		
		graph = new HashMap<>();

		ArrayList<Integer> temp = new ArrayList<>();
		temp.add(2);
		temp.add(3);
		temp.add(4);
		graph.put(1, temp);
		
		temp.add(1);
		temp.add(5); 
		temp.add(6);
		graph.put(2, temp);
		
		temp.add(1);
		temp.add(7);
		temp.add(8);
		graph.put(3, temp);
		
		temp.add(1);
		temp.add(9);
		graph.put(4, temp);

		temp.add(2);
		graph.put(5, temp);
		
		temp.add(2);
		graph.put(6, temp);
		
		temp.add(3);
		graph.put(7, temp);

		temp.add(3);
		graph.put(8, temp);

		temp.add(4);
		graph.put(9, temp);

		BFS(graph, 1);
		
	}
	
	static void BFS(HashMap<Integer, ArrayList<Integer>> graph, int idx) {
		
		need_visit.add(idx);
		
		while(need_visit.size() != 0) {
			int value = (int) need_visit.pollLast();
			
			
			boolean visited_none = true;
			
			for(int i=0;i<visited.size();i++) {
				if(visited.get(i) == value)
					visited_none = false;
			}
			
			
			if(visited_none) {
				for(Object i : graph.get(value).toArray())
					need_visit.add((Integer) i);
				visited.add(value);
			}
		}
		
		Iterator<Integer> iter = visited.iterator();
		
		while(iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
	}

}
