package Algorithm.BinaryTree;

import java.util.Arrays;

/**
 * @see <a href="http://ejklike.github.io/2018/01/09/traversing-a-binary-tree-1.html">���� Ž�� ��ó</a>
 * @author binst
 *
 */
public class BinaryTree {
	public static void main(String args[]) {
		BinaryTreeManager btm = new BinaryTreeManager(new Node(50));
		
		int[] dataArr = new int[100];
		Arrays.fill(dataArr, 100);
		
		int i = 0;
		
		for(int num : dataArr) {
			btm.addNode(i);
		}
		
		int[] testArr = new int[100];
		
		for(int num2 : dataArr) {
			if(!btm.delete(num2)) {
				System.out.println("error �߻�");
			}
		}
	}
}

class Node{
	Node childNodeLeft;
	Node childNodeRight;
	int value;
	
	public Node(int value) {
		this.value = value;
	}
	
	void setNodeLeft(Node childNodeLeft) {
		this.childNodeLeft = childNodeLeft;
	}
	
	void setNodeRight(Node childNodeRight) {
		this.childNodeRight = childNodeRight;
	}
	
	Node getNodeLeft() {
		return childNodeLeft;
	}
	
	Node getNodeRight() {
		return childNodeRight;
	}
	
}

class BinaryTreeManager{
	Node currentNode;
	Node parentNode;
	Node headNode;
	
	public BinaryTreeManager(Node headNode) {
		this.headNode = headNode;
		this.currentNode = headNode;
	}
	
	void addNode(int value) {

		this.currentNode = this.headNode;
		
		while(true) 
		{	
			if(value < this.currentNode.value) 
			{
				if(this.currentNode.getNodeLeft() != null)
				{
					this.currentNode = this.currentNode.getNodeLeft();
				}
				else
				{
					this.currentNode.setNodeLeft(new Node(value));
					break;
				}
			}
			else if(value > this.currentNode.value)
			{
				if(this.currentNode.getNodeRight() != null)
				{
					this.currentNode = this.currentNode.getNodeRight();
				}
				else
				{
					this.currentNode.setNodeRight(new Node(value));
					break;
				}
			}
		}
	}
	
	boolean search(int value) {

		this.currentNode = this.headNode;
		
		while(this.currentNode != null)
		{
			if(this.currentNode.value == value) 
			{
				return true;
			}
			else if(this.currentNode.value > value)
			{	
				this.currentNode = this.currentNode.getNodeLeft();
			}
			else
			{
				this.currentNode = this.currentNode.getNodeRight();
			}
		}
		
		return false;
	}
	
	boolean delete(int value) {
		
		boolean searched = false;
		this.currentNode = this.headNode;
		this.parentNode = this.headNode;
		
		while(this.currentNode != null) {
			if(this.currentNode.value < value)
			{
				this.currentNode = this.currentNode.getNodeRight();
			}
			else if(this.currentNode.value > value)
			{
				this.currentNode = this.currentNode.getNodeLeft();
			}
			else
			{
				searched = true;
				break;
			}
		}
		
		//case1 leaf Node
		if(this.currentNode.getNodeLeft() == null && this.currentNode.getNodeRight() == null) 
		{
			if(value < this.parentNode.value)
				this.parentNode.setNodeLeft(null);
			else
				this.parentNode.setNodeRight(null);
		}
		
		//case2 ������ ��尡  child node�� �� �� ������ ���� ���
		if(this.currentNode.getNodeLeft() != null && this.currentNode.getNodeRight() == null)
		{
			if(value < this.currentNode.value)
			{
				this.parentNode.setNodeLeft(this.currentNode.getNodeLeft());	
			}
			else
			{
				this.parentNode.setNodeRight(this.currentNode.getNodeRight());
			}
		}
		else if(this.currentNode.getNodeLeft() != null && this.currentNode.getNodeRight() == null)
		{
			if(this.currentNode.value < value)
			{
				this.parentNode.setNodeRight(this.currentNode.getNodeRight());
			}
			else
			{
				this.parentNode.setNodeLeft(this.currentNode.getNodeLeft());
			}
		}
		
		//case3 ������ ��尡  child node�� ���ʿ� ������ �ִ� ���
		if(this.currentNode.getNodeLeft() != null && this.currentNode.getNodeRight() != null)
		{
			
			//case3-1
			if(value < this.parentNode.value) 
			{
				Node change_node = this.currentNode.getNodeRight();
				Node change_node_parent = this.currentNode.getNodeRight();
				
				while(change_node.getNodeLeft() != null)
				{
					change_node_parent = change_node;
					change_node = change_node_parent.getNodeLeft();
				}
				if(change_node.getNodeRight() != null) 
				{
					change_node_parent.setNodeLeft(change_node.getNodeRight());
				}
				else
				{
					change_node_parent.setNodeLeft(null);
				}
				this.parentNode.setNodeLeft(change_node);
				change_node.setNodeLeft(this.currentNode.getNodeLeft());
				change_node.setNodeRight(this.currentNode.getNodeRight());
			}
			//case3-1
			else
			{
				Node change_node = this.currentNode.getNodeLeft();
				Node change_node_parent = this.currentNode.getNodeLeft();
				
				while(change_node.getNodeRight() != null)
				{
					change_node_parent = change_node;
					change_node = change_node_parent.getNodeRight();
				}
				if(change_node.getNodeLeft() != null) 
				{
					change_node_parent.setNodeRight(change_node.getNodeLeft());
				}
				else
				{
					change_node_parent.setNodeRight(null);
				}
				this.parentNode.setNodeRight(change_node);
				change_node.setNodeLeft(this.currentNode.getNodeLeft());
				change_node.setNodeRight(this.currentNode.getNodeRight());
			}
		}
		
		
		return true;
	}
}




















