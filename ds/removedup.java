class Node{

	public int data;
	public Node next;

	public Node(int data){
		this.data = data;
		next = null;
	}
	public Node add(int n){
		Node newNode  = new Node(n);
		newNode.next = this;
		return newNode;
	}

}

class Driver{

	public static Node removeDup(Node root){
		
		if(root == null)
			return null;

		Node prev = root;	

		Node current = root.next;

		while(current != null){

			Node runner = root;
			while(runner != current){

				if(runner.data == current.data){
					prev.next = current.next;
					break;
				}	
				runner = runner.next;		
			}
			prev = current;
			current = current.next;
		}
		return root;
	}
	
	public static void print(Node root){
		while(root!= null){
			System.out.print(root.data+"->");
			root = root.next;
		}
	}

	public static void main(String ...args){
		Node root = new Node(4);
		root = root.add(2);
		root = root.add(5);
		root = root.add(2);
		root = root.add(1);

		root = removeDup(root);
		print(root);
		// print LL here
	}

}
