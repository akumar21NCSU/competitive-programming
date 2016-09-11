import java.util.*;
class Node{
	public int value;
	public Node lchild;
	public Node rchild;

	public Node(int v){this.value =v;}

}



class Driver{

	public static java.util.HashMap<Integer,java.util.LinkedList<Node>> map;

	public static void vorder(Node n,int v){

		if(n== null)
			return ;

		vorder(n.lchild,v-1);
		java.util.LinkedList<Node> l = map.get(v);
		if(l == null){
			l = new java.util.LinkedList<Node>();
			map.put(v,l);
		}
		l.add(n);
		
		vorder(n.rchild,v+1);

	}

	public static void main(String ...args){
		Node n1 = new Node(1);
		Node n2 = new Node(2);	
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);	
		Node n9 = new Node(9);

		n1.lchild = n2;
		n1.rchild = n3;

		n2.lchild=n4;
		n2.rchild=n5;

		n3.lchild=n6;
		n3.rchild=n7;

		n6.rchild=n8;
		n7.rchild=n9;
					
		map = new java.util.LinkedHashMap<Integer,java.util.LinkedList<Node>>();	

		vorder(n1,0);
	
		for(int k: map.keySet()){
			java.util.LinkedList<Node> v =map.get(k);
			for(Node n: v)
				System.out.println("Key is = "+k+" value is = " +n.value);

		}

			
	}

}
