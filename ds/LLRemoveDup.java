class LLRemoveDup{

	public static void removeDup(Node root){

		java.util.HashMap<Integer, Boolean> map = new java.util.HashMap<Integer,Boolean>();

		Node cur = root;
		
		if(root == null)
			return;

		map.put(root.getValue(),true);
		
		while(cur.getNext() != null){
			if(map.containsKey(cur.getNext().getValue())){
				cur.setNext( (cur.getNext()).getNext());
			}else{
				map.put(cur.getNext().getValue(),true);
				cur = cur.getNext();
			}			
		}

		
	}

	public static void printLL(Node root){

		while(root != null){
			System.out.print(root.getValue()+" ");
			root = root.getNext();
		}
	}

	public static void main(String ...args)throws Exception{
		
		Node root = new Node(1);
		Node node1 = new Node(2);
		Node node2 = new Node(1);
		Node node3 = new Node(4);
		Node node4 = new Node(2);

		root = root.addHead(node1);
		root = root.addHead(node2);
		root = root.addHead(node3);
		root = root.addHead(node4);
		printLL(root);
		System.out.println();
		removeDup(root);		
		printLL(root);
		

	}

}
