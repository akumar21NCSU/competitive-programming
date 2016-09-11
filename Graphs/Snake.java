class Node{
	private int pos;
	private java.util.LinkedList<Node> adj;

	private Node(int v){
		pos =v;
		adj = new java.util.LinkedList<Node>();
	}

	private void addNode(Node dest){
		adj.add(dest);
	}

}

class Driver{

	private static java.util.HashMap<Integer,Integer> sol;
	
	private static int[] memo;

	public static int bfs(Node[] board,int cur,int cap, boolean[] visited){
		
		if(memo[cur] < 999){
			//System.out.println("for cur"+cur+" returning "+ memo[cur]);
			return memo[cur];

		}
	
		if(visited[cur])
			return 999;
		
		if(sol.containsKey(cur) ){
			visited[cur] = true;
			int moves = bfs(board,sol.get(cur),cap,visited);
			memo[cur] = moves;
			return moves;
		}

		java.util.LinkedList adj = board[cur].adj;
		visited[cur] = true;
		int moves = 999;
		for(Object o: adj){
			Node n = (Node)o;			

			 int temp = bfs(board,n.pos,cap,visited) + 1;
				if(temp < moves)
					moves = temp;
		}
		memo[cur] = moves;
		return moves;
	}

	public static void main(String ... args){

		int cap = 30;
		Node board[] = new Node[cap+1];

		for(int i=1;i<=cap;i++){
			board[i] = new Node(i);
		}		
		for(int i=1;i<cap;i++){
			for(int j=1;j<=6;j++){
				if(i+j > cap)
					break;
				board[i].addNode(board[i+j]);
			}
		}

		boolean[] visited = new boolean[cap+1];

		memo = new int[cap+1];		
		for(int i =0;i<=cap;i++)
			memo[i] =999;
		//ladders and snakes
		sol = new java.util.HashMap<Integer,Integer>();	
		sol.put(3,22);	
		sol.put(5,8);
		sol.put(11,26);
		sol.put(20,29);	
		sol.put(27,1);
		sol.put(21,9);
		sol.put(17,4);


		memo[cap] = 0;
		bfs(board,1,cap,visited);

		System.out.println(memo[1]);
	}
}
