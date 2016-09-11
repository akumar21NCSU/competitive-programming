package graph;

public class Edge implements Comparable<Edge>{

	int src;
	int dest;
	int weight;
	
	public Edge(int src,int dest,int weight){
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}

	public int getSrc() {
		return src;
	}

	public void setSrc(int src) {
		this.src = src;
	}

	public int getDest() {
		return dest;
	}

	public void setDest(int dest) {
		this.dest = dest;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		if(this.weight > o.weight)
			return 1;
		else if(this.weight < o.weight)
			return -1;
		else
			return 0;
	}
	
	
	
}
