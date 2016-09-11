package Queue;

public class TNode {

	private String label;
	private int data=0;
	
	private TNode lChild;
	private TNode rChild;
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public TNode getlChild() {
		return lChild;
	}

	public void setlChild(TNode lChild) {
		this.lChild = lChild;
	}

	public TNode getrChild() {
		return rChild;
	}

	public void setrChild(TNode rChild) {
		this.rChild = rChild;
	}

	public TNode(String label,TNode lchild,TNode rchild){
		
		this.label = label;
		this.lChild = lchild;
		this.rChild = rchild;
	}
	
}
