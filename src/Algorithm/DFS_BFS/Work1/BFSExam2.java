package Algorithm.DFS_BFS.Work1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSExam2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static void search(Node root) {
		Queue queue = new LinkedList<Node>();
		root.marked = true;
		queue.add(root);
		
		while(!queue.isEmpty()) {
			Node r = (Node) queue.poll();
			
			
		}
	}
}

class Node {
	ArrayList <Node> list_node;
	int value;
	boolean marked;
	
	public Node(ArrayList<Node> list_node, int value) {
		this.list_node = list_node;
		this.value = value;
		this.marked = false;
	}
}
