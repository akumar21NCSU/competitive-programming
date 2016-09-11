class Stack{

	Node top = null;
	
	public Node pop(){
		if(top != null){
			Node del = top;
			top = top.next;
			return del;
		}
		return null;
	}
	
	public void push(Node n){
		n.next = top;
		top = n;
	}

}

class Queue{
	Node front=null,back=null;

	public Node dequeue(){
		if(front == null)
			return null;

		Node del = front;
		front = front.next;
		return del;
	}

	public void enqueue(Node n){
		if(back == null){
			front = back = n;
			return;
		}
		back.next = n;
		back = n;		
	}

}
