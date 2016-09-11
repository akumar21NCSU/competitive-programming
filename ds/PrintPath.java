class Node{
	public int value;
	public Node lchild;
	public Node rchild;
	
	public Node(int v){this.value=v;}

}

class Driver{
	
	public static boolean printPath(Node n,int k){

		if(n == null)
			return false;

		if(n.value == k){
			System.out.println(n.value);
		}
		
		
		boolean lfind = printPath(n.lchild,k-n.value);
		boolean rfind = printPath(n.rchild,k-n.value);
		
		printPath(n.rchild,k);
		printPath(n.lchild,k);

		if(lfind == true || rfind == true){
			System.out.println(n.value);
			return true;
		}
		return false;

	}

	public static void main(String ...args){

		Node n1 = new Node(10);
		Node n2 = new Node(2);	
		Node n3 = new Node(30);
		Node n4 = new Node(15);
		Node n5 = new Node(5);
		Node n6 = new Node(40);
		Node n7 = new Node(18);
		Node n8 = new Node(8);	
		Node n9 = new Node(12);

		n1.lchild = n2;
		n1.rchild = n3;

		n2.lchild=n4;
		n2.rchild=n5;

		n3.lchild=n6;
		n3.rchild=n7;

		n6.rchild=n8;
		n7.rchild=n9;

		printPath(n1,30);

	}

}

