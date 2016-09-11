package tree;



public class ThreadedBinaryTree {

	private Node root;
	
	public ThreadedBinaryTree(Node root){
		this.root = root;
	}
	
	public ThreadedBinaryTree(){}
	
	public void morrisTraversal(Node root){

		Node cur, prev;
		cur = root;
		
		while(cur != null){
			
			if(cur.left == null){
				System.out.print(cur.value + " ");
				cur = cur.right;
			}else {
				prev = cur.left;
				while(prev.right!= null && prev.right != cur)
					prev = prev.right;
				
				if(prev.right != cur){
					prev.right = cur;
					cur = cur.left;
				}else{
					// 
					prev.right = null;
					System.out.print(cur.value+" ");
					cur = cur.right;
				}
			}
			
		}
	
	}
	
	public static void main(String[] args) {
		
		Node root = new Node(1);
		ThreadedBinaryTree tbtree = new ThreadedBinaryTree();
		
		Node node1 = new Node(1);
		tbtree.root = node1;
		
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
		
		tbtree.morrisTraversal(tbtree.root);
	}

}
