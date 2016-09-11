class LLAddition{

	public static Node add(Node root1, Node root2){

		int carry=0;
		Node cur = root1;
		Node last = root2;

		while(root1 != null || root2 != null){

			int a=0,b=0;
			if(root1 != null)
				a = root1.getValue();
			if(root2 !=null)
				b = root2.getValue();

			int sum = a+b+carry;

			if(sum >= 10){
				carry = 1;
				sum = sum -10;
			}else
				carry=0;
			
			cur.setValue(sum);
			if(root1 !=null){
				root1=root1.getNext();		
			}
			if(root2 !=null)
				root2 = root2.getNext();

			if(root1 != null){
				cur.setNext(root1);
				cur = root1;
			}
			else{
				cur.setNext(root2);
				cur = root2;
			}
		}

		if(	carry > 0){
			last.setValue(carry);
			System.out.println("cur is "+cur.getValue());
			cur.setNext(last);
		}
	
		return cur;

	}

	public static void printLL(Node n){
	
		while(n!= null){
			System.out.print(n.getValue()+" ");
			n = n.getNext();
		}

	}

	public static void main(String ...args)throws Exception{
		
		Node root1 = new Node(1);
		Node node2= new Node(5);
		Node node3 = new Node(3);

		root1 = root1.addHead(node2);
		root1 = root1.addHead(node3);

		Node root2 = new Node(9);
		Node node4= new Node(9);
		Node node5 = new Node(9);
	
		root2 = root2.addHead(node4);
		root2 = root2.addHead(node5);
		printLL(root1);
		printLL(root2);

		root1 = add(root1,root2);
		printLL(root1);

	}

}
