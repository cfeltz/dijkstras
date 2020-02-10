package cs228hw4.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DiGraphTest {

	public static void main(String[] args) {
		ArrayList<String> verticies = new ArrayList<String>();
		verticies.add("V1");
		verticies.add("V2");
		verticies.add("V3");
		verticies.add("V4");
		verticies.add("V5");
		int[][] adjanecyMatrix = new int[verticies.size()][verticies.size()];
		adjanecyMatrix[0][0] = 0;
		adjanecyMatrix[1][0] = 1;
		adjanecyMatrix[2][0] = 3;
		adjanecyMatrix[3][0] = 0;
		adjanecyMatrix[4][0] = 2;
		adjanecyMatrix[0][1] = 0;
		adjanecyMatrix[1][1] = 0;
		adjanecyMatrix[2][1] = 1;
		adjanecyMatrix[3][1] = 0;
		adjanecyMatrix[4][1] = 0;
		adjanecyMatrix[0][2] = 0;
		adjanecyMatrix[1][2] = 0;
		adjanecyMatrix[2][2] = 0;
		adjanecyMatrix[3][2] = 1;
		adjanecyMatrix[4][2] = 3;
		adjanecyMatrix[0][3] = 0;
		adjanecyMatrix[1][3] = 0;
		adjanecyMatrix[2][3] = 0;
		adjanecyMatrix[3][3] = 0;
		adjanecyMatrix[4][3] = 5;
		adjanecyMatrix[0][4] = 0;
		adjanecyMatrix[1][4] = 0;
		adjanecyMatrix[2][4] = 0;
		adjanecyMatrix[3][4] = 0;
		adjanecyMatrix[4][4] = 0;
		GraphImp<String> graph = new GraphImp<String>(adjanecyMatrix, verticies);
		System.out.println(graph.numVertices()); //5
		Set<? extends String> neighbors = graph.getNeighbors("V1");
		Set<? extends String> neighbors1 = graph.getNeighbors("V2");
		Set<? extends String> neighbors2 = graph.getNeighbors("V3");
		Set<? extends String> neighbors3 = graph.getNeighbors("V4");
		Set<? extends String> neighbors4 = graph.getNeighbors("V5");
		System.out.println(graph.getEdgeCost("V1", "V3")); //3
		System.out.println(graph.getEdgeCost("V1", "V2")); //1
		System.out.println(graph.getEdgeCost("V1", "V1")); //0
		System.out.println(graph.getEdgeCost("V4", "V5")); //5
		//System.out.println(graph.getEdgeCost("V5", "V3")); //Exception
		Iterator<String> it = graph.iterator();
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());
		CS228Dijkstra<String> dijkstra = new CS228Dijkstra<String>(graph);
		dijkstra.run("V1");
		System.out.println(dijkstra.getShortestDistance("V1")); //0
		List<String> aList4 = dijkstra.getShortestPath("V1"); //V1
		System.out.println(dijkstra.getShortestDistance("V2")); //1
		List<String> aList3 = dijkstra.getShortestPath("V2"); //V1, V2
		System.out.println(dijkstra.getShortestDistance("V3")); //2
		List<String> aList2 = dijkstra.getShortestPath("V3"); //V1, V2, V3
		System.out.println(dijkstra.getShortestDistance("V4")); //3
		List<String> aList1 = dijkstra.getShortestPath("V4"); //V1, V2, V3, V4
		System.out.println(dijkstra.getShortestDistance("V5")); //2
		List<String> aList = dijkstra.getShortestPath("V5"); //V1, V5
		//Graph test case 2
		ArrayList<Integer> verticies1 = new ArrayList<Integer>();
		verticies1.add(1);
		verticies1.add(2);
		verticies1.add(3);
		verticies1.add(4);
		verticies1.add(5);
		int[][] adjanecyMatrix1 = new int[verticies1.size()][verticies1.size()];
		adjanecyMatrix1[0][0] = 0;
		adjanecyMatrix1[1][0] = 8;
		adjanecyMatrix1[2][0] = 7;
		adjanecyMatrix1[3][0] = 6;
		adjanecyMatrix1[4][0] = 0;
		adjanecyMatrix1[0][1] = 0;
		adjanecyMatrix1[1][1] = 0;
		adjanecyMatrix1[2][1] = 2;
		adjanecyMatrix1[3][1] = 5;
		adjanecyMatrix1[4][1] = 0;
		adjanecyMatrix1[0][2] = 0;
		adjanecyMatrix1[1][2] = 0;
		adjanecyMatrix1[2][2] = 0;
		adjanecyMatrix1[3][2] = 0;
		adjanecyMatrix1[4][2] = 1;
		adjanecyMatrix1[0][3] = 0;
		adjanecyMatrix1[1][3] = 1;
		adjanecyMatrix1[2][3] = 0;
		adjanecyMatrix1[3][3] = 0;
		adjanecyMatrix1[4][3] = 10;
		adjanecyMatrix1[0][4] = 0;
		adjanecyMatrix1[1][4] = 0;
		adjanecyMatrix1[2][4] = 0;
		adjanecyMatrix1[3][4] = 0;
		adjanecyMatrix1[4][4] = 0;
		System.out.println("***********");
		GraphImp<Integer> graph1 = new GraphImp<Integer>(adjanecyMatrix1, verticies1);
		CS228Dijkstra<Integer> dijkstra1 = new CS228Dijkstra<Integer>(graph1);
		dijkstra1.run(1);
		System.out.println(dijkstra1.getShortestDistance(1));
		System.out.println(dijkstra1.getShortestDistance(2));
		System.out.println(dijkstra1.getShortestDistance(3));
		System.out.println(dijkstra1.getShortestDistance(4));
		System.out.println(dijkstra1.getShortestDistance(5));
		List<Integer> aListA = dijkstra1.getShortestPath(1);
		List<Integer> aListB = dijkstra1.getShortestPath(2);
		List<Integer> aListC = dijkstra1.getShortestPath(3);
		List<Integer> aListD = dijkstra1.getShortestPath(4);
		List<Integer> aListE = dijkstra1.getShortestPath(5);
		System.out.println(graph1.getEdgeCost(4, 5));
		System.out.println("");
		ArrayList<String> xVertices = new ArrayList<String>();
		xVertices.add("A");
		xVertices.add("B");
		xVertices.add("C");
		xVertices.add("D");
		xVertices.add("E");
		xVertices.add("F");
		xVertices.add("G");
		xVertices.add("H");
		xVertices.add("I");
		xVertices.add("J");
		int[][] xAdjanecyMatrix = new int[xVertices.size()][xVertices.size()];
		xAdjanecyMatrix[0][0] = 0;
		xAdjanecyMatrix[1][0] = 9;
		xAdjanecyMatrix[2][0] = 0;
		xAdjanecyMatrix[3][0] = 5;
		xAdjanecyMatrix[4][0] = 0;
		xAdjanecyMatrix[5][0] = 0;
		xAdjanecyMatrix[6][0] = 0;
		xAdjanecyMatrix[7][0] = 0;
		xAdjanecyMatrix[8][0] = 0;
		xAdjanecyMatrix[9][0] = 0;
		xAdjanecyMatrix[0][1] = 0;
		xAdjanecyMatrix[1][1] = 0;
		xAdjanecyMatrix[2][1] = 7;
		xAdjanecyMatrix[3][1] = 0;
		xAdjanecyMatrix[4][1] = 7;
		xAdjanecyMatrix[5][1] = 0;
		xAdjanecyMatrix[6][1] = 0;
		xAdjanecyMatrix[7][1] = 0;
		xAdjanecyMatrix[8][1] = 0;
		xAdjanecyMatrix[9][1] = 0;
		xAdjanecyMatrix[0][2] = 0;
		xAdjanecyMatrix[1][2] = 0;
		xAdjanecyMatrix[2][2] = 0;
		xAdjanecyMatrix[3][2] = 0;
		xAdjanecyMatrix[4][2] = 0;
		xAdjanecyMatrix[5][2] = 2;
		xAdjanecyMatrix[6][2] = 0;
		xAdjanecyMatrix[7][2] = 13;
		xAdjanecyMatrix[8][2] = 0;
		xAdjanecyMatrix[9][2] = 0;
		xAdjanecyMatrix[0][3] = 0;
		xAdjanecyMatrix[1][3] = 13;
		xAdjanecyMatrix[2][3] = 0;
		xAdjanecyMatrix[3][3] = 0;
		xAdjanecyMatrix[4][3] = 0;
		xAdjanecyMatrix[5][3] = 0;
		xAdjanecyMatrix[6][3] = 2;
		xAdjanecyMatrix[7][3] = 0;
		xAdjanecyMatrix[8][3] = 0;
		xAdjanecyMatrix[9][3] = 0;
		xAdjanecyMatrix[0][4] = 0;
		xAdjanecyMatrix[1][4] = 0;
		xAdjanecyMatrix[2][4] = 0;
		xAdjanecyMatrix[3][4] = 0;
		xAdjanecyMatrix[4][4] = 0;
		xAdjanecyMatrix[5][4] = 12;
		xAdjanecyMatrix[6][4] = 8;
		xAdjanecyMatrix[7][4] = 0;
		xAdjanecyMatrix[8][4] = 0;
		xAdjanecyMatrix[9][4] = 0;
		xAdjanecyMatrix[0][5] = 0;
		xAdjanecyMatrix[1][5] = 0;
		xAdjanecyMatrix[2][5] = 0;
		xAdjanecyMatrix[3][5] = 0;
		xAdjanecyMatrix[4][5] = 0;
		xAdjanecyMatrix[5][5] = 0;
		xAdjanecyMatrix[6][5] = 0;
		xAdjanecyMatrix[7][5] = 0;
		xAdjanecyMatrix[8][5] = 0;
		xAdjanecyMatrix[9][5] = 0;
		xAdjanecyMatrix[0][6] = 0;
		xAdjanecyMatrix[1][6] = 0;
		xAdjanecyMatrix[2][6] = 0;
		xAdjanecyMatrix[3][6] = 0;
		xAdjanecyMatrix[4][6] = 0;
		xAdjanecyMatrix[5][6] = 0;
		xAdjanecyMatrix[6][6] = 0;
		xAdjanecyMatrix[7][6] = 6;
		xAdjanecyMatrix[8][6] = 5;
		xAdjanecyMatrix[9][6] = 0;
		xAdjanecyMatrix[0][7] = 0;
		xAdjanecyMatrix[1][7] = 0;
		xAdjanecyMatrix[2][7] = 0;
		xAdjanecyMatrix[3][7] = 0;
		xAdjanecyMatrix[4][7] = 0;
		xAdjanecyMatrix[5][7] = 0;
		xAdjanecyMatrix[6][7] = 0;
		xAdjanecyMatrix[7][7] = 0;
		xAdjanecyMatrix[8][7] = 0;
		xAdjanecyMatrix[9][7] = 0;
		xAdjanecyMatrix[0][8] = 0;
		xAdjanecyMatrix[1][8] = 0;
		xAdjanecyMatrix[2][8] = 0;
		xAdjanecyMatrix[3][8] = 0;
		xAdjanecyMatrix[4][8] = 0;
		xAdjanecyMatrix[5][8] = 0;
		xAdjanecyMatrix[6][8] = 0;
		xAdjanecyMatrix[7][8] = 0;
		xAdjanecyMatrix[8][8] = 0;
		xAdjanecyMatrix[9][8] = 13;
		xAdjanecyMatrix[0][9] = 0;
		xAdjanecyMatrix[1][9] = 0;
		xAdjanecyMatrix[2][9] = 0;
		xAdjanecyMatrix[3][9] = 0;
		xAdjanecyMatrix[4][9] = 0;
		xAdjanecyMatrix[5][9] = 0;
		xAdjanecyMatrix[6][9] = 0;
		xAdjanecyMatrix[7][9] = 0;
		xAdjanecyMatrix[8][9] = 0;
		xAdjanecyMatrix[9][9] = 0;
		GraphImp<String> x = new GraphImp<String>(xAdjanecyMatrix, xVertices);
		System.out.println(x.getNeighbors("D"));
		
		System.out.println(x.getEdgeCost("D", "B"));
		
		CS228Dijkstra<String> f = new CS228Dijkstra<String>(x);
		f.run("A");
		System.out.println(f.getShortestDistance("J"));
		System.out.println(f.getShortestPath("J"));
	}

}
