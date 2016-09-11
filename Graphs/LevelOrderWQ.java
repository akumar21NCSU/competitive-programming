package tree;

public class LevelOrderWQ {
	
private static Node root;
	private static int maxCount=0;
	
	public LevelOrderWQ(int v){
		root = new Node(v);
	}
	public LevelOrderWQ(){
		root = null;
	}
	
	public static int height(Node root){
		if(root == null)
			return 0;
		
		return java.lang.Math.max(height(root.left),height(root.right))+1;
	}
	
	public static int printGivenLevel(Node root, int level){
		if(root == null)
			return 0;
		
		int count=0;
		
		if(level == 1)
			count++;
		
		else{
			count += printGivenLevel(root.left,level-1);
			count += printGivenLevel(root.right,level-1);
		}
		if(count > maxCount)
			maxCount = count;
		return count;	
	}
	
	public static void main(String[] args) {
		   LevelOrderWQ tree = new LevelOrderWQ();
	       tree.root= new Node(1);
	       tree.root.left= new Node(2);
	       tree.root.right= new Node(3);
	       tree.root.right.right = new Node(6);
	       tree.root.left.left= new Node(4);
	       tree.root.left.right= new Node(5);
	       
	       int h = height(tree.root);
	       for(int i=1;i<=h;i++)
	    	   printGivenLevel(root, i);
	       
	       System.out.println(maxCount);
	}

}
