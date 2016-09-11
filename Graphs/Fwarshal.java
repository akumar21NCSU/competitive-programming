package graph;

public class Fwarshal {

	private static final int INF = 99999;
	
	public static void floydWarshal(int[][] graph, int V){
		
		int sol[][] = new int[V][V];
		for(int i=0;i<V;i++)
			for(int j=0;j<V;j++)
				sol[i][j] = graph[i][j];
		
		for(int k =0;k<V;k++)
			for(int i=0;i<V;i++)
				for(int j=0;j<V;j++)
					if(sol[i][k] + sol[k][j] < sol[i][j])
						sol[i][j] = sol[i][k] + sol[k][j];
		
		printSolution(sol,V);
		
	}
	public static void printSolution(int[][] sol, int V){
		for(int i=0;i<V;i++){
			for(int j=0;j<V;j++)
				System.out.print(sol[i][j]+ " ");
			System.out.println();
		}
			
	}
	public static void main(String[] args) {
		int graph[][] = { {0,   5,  INF, 10},
                {INF, 0,   3, INF},
                {INF, INF, 0,   1},
                {INF, INF, INF, 0}
              };
		int V = 4;
		
		floydWarshal(graph,V);
		
	}

}
