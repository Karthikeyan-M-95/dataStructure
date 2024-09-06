package BinaryTree;

import java.util.Stack;

public class BinarySearchTree {
	
	private Node root;
	
	private class Node{
		private int data;
		private Node left;
		private Node right;
		
		Node(int val){
			this.data=val;
			this.left=this.right=null;
		}
	}
	
	private Node insertElement(Node root, int val) {
		
		if(root==null) {
			Node node=new Node(val);
			root= node;
		}
		else if(val>root.data) {
			root.right=insertElement(root.right, val);
		}
		else if(val<root.data) {
			root.left=insertElement(root.left, val);
		}
		
		return root;
	}
	
	
	public void addElement(int val) {
		root= insertElement(root, val);
	}

	public void preOrder(Node root) {
		if(root==null)
			return;
		System.out.print(root.data+ " -> ");
		preOrder(root.left);
		preOrder(root.right);
//		System.out.println();
	}
	
	public void preOrderStackImpl(Node root) {
		Stack<Node> stk = new Stack<Node>();
		stk.push(root);
		while(!stk.isEmpty()) {
			Node temp = stk.pop();
			System.out.print(temp.data+" -> ");
			if(temp.right!=null)
				stk.push(temp.right);
			if(temp.left!=null)
				stk.push(temp.left);
		}
		System.out.println();
	}
	
	public void inOrder(Node root) {
		if(root==null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.data+" --> ");
		inOrder(root.right);
	}
	
	public void inOrderStackImpl(Node root) {
		Node temp = root;
		Stack<Node> stk = new Stack<Node>();
//		stk.push(temp);
		System.out.println();
		while(!stk.isEmpty() || temp != null) {
			if(temp!=null) {
				stk.push(temp);
				temp=temp.left;
			}else {
				temp = stk.pop();
				System.out.print(temp.data+" -> ");
				temp=temp.right;
			}
		}
	}

	public void postOrder(Node root) {
		if(root==null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+" -> ");
	}
	
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.addElement(10);
		bst.addElement(5);
		bst.addElement(15);
		bst.addElement(3);
		bst.addElement(9);
		bst.addElement(13);
		bst.preOrder(bst.root);
		System.out.println();
//		bst.preOrderStackImpl(bst.root);
		bst.inOrder(bst.root);
//		bst.inOrderStackImpl(bst.root);
		System.out.println();
		bst.postOrder(bst.root);
	}
}
