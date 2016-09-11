package tree;

import java.util.LinkedList;

class Node{
	 int value;
	 Node left,right;
	
	public Node(int v){
		this.value = v;
		this.left = this.right = null;
	}
}

public class BinaryTree {

	private Node root;
	
	public BinaryTree(int v){
		root = new Node(v);
	}
	public BinaryTree(){
		root = null;
	}
	
	public static int height(Node root){
		if(root == null)
			return 0;
		
		return java.lang.Math.max(height(root.left)+1, height(root.right)+1);
	}
	
	public static int diameter(Node root){
		
		if(root == null)
			return 0;
		
		int lHeight = height(root.left);
		int rHeight = height(root.right);
		int diam = lHeight + rHeight +1;
		
		return java.lang.Math.max(diam, java.lang.Math.max(diameter(root.left),diameter(root.right)));
		
	}
	
	public static void inorder(Node root){
		if(root == null)
			return;
		
		inorder(root.left);
		System.out.print(root.value+ " ");
		inorder(root.right);
		
	}
	
	public static void inorderWR(Node root){
		
		LinkedList<Node> stack = new LinkedList<Node>();
		//stack.push(root);
		Node cur =root;
		
		while(cur != null){
			stack.push(cur);
			cur = cur.left;			
		}
		
		while(!stack.isEmpty()){			
			cur = stack.pop();			
			//System.out.println("Curr is "+cur.value);
			System.out.print(cur.value +" ");
			
			if(cur.right != null){
				
				cur = cur.right;
				while(cur != null){
					stack.push(cur);
					cur = cur.left;
				}
			}
		}
	}	
	
	public static void main(String[] args) {
		
		BinaryTree btree = new BinaryTree();
		
		Node node1 = new Node(1);
		btree.root = node1;
		
		Node node2 = new Node(2);
		Node node3 = new Node(3);		
		Node node4 = new Node(4);
		Node node5 = new Node(5);		
		Node node6 = new Node(6);	
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		Node node9 = new Node(9);
		Node node10 = new Node(10);
		Node node11= new Node(11);
		
		Node node12 = new Node(12);
		Node node13 = new Node(13);
		Node node14 = new Node(14);
		Node node15= new Node(15);
		Node node16= new Node(16);
		
		node1.left = node2;
		node1.right = node3;
		
		node2.left = node4;
		node2.right = node5;
		
		node3.right = node9;
		
		node4.left = node6;
		node4.right = node7;
		
		node7.left = node10;
		
		node10.left = node11;
		node10.right = node12;
		
		node5.right = node8;
		
		node8.left = node13;
		node8.right = node14;
		
		node14.right = node15;
		node15.right = node16;
		
		//int diam = diameter(btree.root);
		//System.out.println(diam);
		
		inorder(btree.root);
		System.out.println();
		inorderWR(btree.root);
		
	}
	
}

