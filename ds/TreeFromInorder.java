package tree;

public class TreeFromInorder {

	public static int indexOf(int node, int[] ar){
		
		for(int i=0;i<ar.length;i++)
			if(ar[i] == node)
				return i;
		
		return -1;
	}
	public static int counter=0;
	
	public static int getNext(int[] prear){
		return prear[counter++];
	}
	public static Node buildTree(Node node,int[] inar, int[] prear,int low, int high){
		
		if(counter == prear.length)
			return null;
		int	 nextEle = getNext(prear);
		int index = indexOf(nextEle,inar);
		
		//System.out.println("Next ele is "+nextEle);
		node = new Node(inar[index]);
		
		if(low == index)
			node.left = null;
		else
			node.left = buildTree(node,inar,prear,low,index -1);
		
		if(high == index)
			node.right = null;
		else
			node.right = buildTree(node,inar,prear,index+1,high);
		
		return node;
	}
	
	public static void main(String[] args) {
		int inar[] = {6,4,11,10,12,7,2,5,13,8,14,15,16,1,3,9};
		int prear[] = {1,2,4,6,7,10,11,12,5,8,13,14,15,16,3,9};
		//int inar[] = {8,10,4,2,9,5,1,6,3,7};
		//int prear[] = {1,2,4,8,10,5,9,3,6,7};
		
		//int rootIndex = indexOf(prear[0],inar);
		Node root = buildTree(null,inar,prear,0,inar.length-1);	
		
		inorder(root);
		
	}
	public static void inorder(Node root){
		if(root == null)
			return;
		
		inorder(root.left);
		System.out.print(root.value+ " ");
		inorder(root.right);
		
	}
}
