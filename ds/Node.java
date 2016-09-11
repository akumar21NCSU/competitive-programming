class Node{
	int value;
	Node next;

	public Node(int v){
		this.value=v;
		next = null;
	}

	public Node addHead(Node n){
		n.setNext(this) ;
		return n;
	}

	public Node getNext(){
		return this.next;
	}
	
	public void setNext(Node n){
		this.next = n;
	}

	public int getValue(){
		return this.value;
	}

	public void setValue(int v){this.value=v;}

}
