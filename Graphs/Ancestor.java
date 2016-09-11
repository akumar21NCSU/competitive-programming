package tree;

public class Ancestor {

	private Node root;
	
	public static boolean printAncestors(Node root, int val){
		
		if(root == null)
			return false;
		
		if(root.value == val){
			return true;
		}
		
		boolean found = printAncestors(root.left,val);
		if(found){
			System.out.print(root.value+ " ");
			return true;
		}
		found = printAncestors(root.right, val);
		if(found){
			System.out.print(root.value+ " ");
			return true;
		}	
			
		return found;
		
	}
	
	public static void main(String[] args) {
		Ancestor btree = new Ancestor();
		
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
		
		printAncestors(btree.root, 7);
	}

}
