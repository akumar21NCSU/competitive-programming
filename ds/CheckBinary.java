package Queue;

import java.util.*;

public class CheckBinary {

	public static TNode generator(String data){
		
		return new TNode(data,null,null);
	}
	
	public static boolean isBinary(TNode root){
		
		if(root == null)
			return false;
		
		Queue<TNode> q = new LinkedList<TNode>();
		
		q.add(root);
		boolean leafReached = false;
		
		while(!q.isEmpty()){
			
			TNode cur = q.poll();
			
			boolean hasLChild = false;
			boolean hasRChild = false;
			
			
			if(cur.getlChild() != null){
				if(leafReached)
					break;
				hasLChild = true;
				q.add(cur.getlChild());
			}
			if(cur.getrChild() != null){
				if(leafReached)
					break;
				hasRChild = true;
				q.add(cur.getrChild());
			}
			
			if(hasLChild == false && hasRChild ==  true)
				break;
			
			if(hasLChild  == false && hasRChild == false)
				leafReached = true;
			
							
		}
		
		if(q.isEmpty())
			return true;
		else
			return false;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TNode root = new TNode("1",null,null);
		
		TNode node2 = generator("2");
		TNode node3 = generator("3");
		TNode node4 = generator("4");
		TNode node5 = generator("5");
		TNode node6 = generator("6");
		TNode node7 = generator("7");
		TNode node8 = generator("8");
		
		root.setlChild(node2);
		root.setrChild(node3);
		
		node2.setlChild(node4);
		node2.setrChild(node5);
		
		//node3.setlChild(node7);
		//node3.setrChild(node6);
		
		node4.setlChild(node8);
		
		System.out.println("Is this tree a complete binary tree - "+ isBinary(root));
	}

}
