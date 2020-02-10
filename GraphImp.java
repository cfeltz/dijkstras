package cs228hw4.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GraphImp<V> implements DiGraph<V> {

	private int[][] adjmatrix;
	private HashMap<Integer, V> names; // hashmap of the names and their position in the adjmatrix

	public GraphImp(int[][] adjmatrix, ArrayList<V> names) {
		this.adjmatrix = adjmatrix;
		this.names = new HashMap<Integer, V>();
		for (int i = 0; i < names.size(); i++) {
			this.names.put(new Integer(i), names.get(i));
		}
	}

	@Override
	public Set<V> getNeighbors(Object vertex) {
		if (vertex.equals(null)) {
			throw new IllegalArgumentException();
		}

		int col = contained(vertex);

		if (col == -1) {
			throw new IllegalArgumentException();
		}
		HashSet<V> returning = new HashSet<V>();
		for (int i = 0; i < adjmatrix[0].length; i++) {
			if (adjmatrix[i][col] > 0) {
				returning.add(names.get(i));
			}
		}

		return returning;
	}

	private int contained(Object vertex) {
		int pos = -1;
		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).equals(vertex)) {
				pos = i;
			}
		}
		return pos;
	}

	// nodes are not null
	// nodes must have connection between them
	@Override
	public int getEdgeCost(Object start, Object end) {
		if (start.equals(null) || end.equals(null)) {
			throw new IllegalArgumentException();
		}

		int rows = contained(start);
		int col = contained(end);

		return adjmatrix[col][rows];
	}

	@Override
	public int numVertices() {

		return names.size();
	}

	@Override
	public Iterator iterator() {

		return new myIterator();
	}

	private class myIterator implements Iterator<V> {
		int pos;

		private myIterator() {
			pos = -1;
		}

		@Override
		public boolean hasNext() {

			return pos + 1 < numVertices();
		}

		@Override
		public V next() {
			pos++;
			return names.get(pos);
		}

	}
	
	public static void main(String[] args)
	{
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
		
	
		
		HashSet<String> test = (HashSet<String>) graph.getNeighbors("V1");
		
		
	}

}
