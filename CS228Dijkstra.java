package cs228hw4.graph;

import java.util.ArrayList;


import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 
 * @author Christopher Feltz
 *
 * @param <V>
 */

public class CS228Dijkstra<V> implements Dijkstra<V> {

	private DiGraph<V> graph;
	private ArrayList<V>[] lists;
	private HashMap<V, Integer> distances;

	/**
	 * Steps to complete dijkstra's algorithm 1. Begin at starting vertex 2. Scan
	 * nodes that are connected to this vertex 3. Get edge cost of nodes connected
	 * to startVertex. 4. Select edge with lowest cost that is connected to
	 * startVertex. 5.
	 * 
	 * from section be the last photo before break
	 * 
	 * 
	 */

	public CS228Dijkstra(DiGraph<V> graph) {
		this.graph = graph;
		distances = new HashMap<V, Integer>(graph.numVertices());
		lists = new ArrayList[this.graph.numVertices()];

	}

	/**
	 * 
	 * This method computes all of the shortest paths, and distances from the given starting vertex. It uses a hash map full of updated distances,
	 * a second hashmap with the correct paths, a hashset full of vertices already visted, an iterator to traverse the given graph, a priority queue
	 * that keeps track of the non visited vertices, and a comparator that overrides the comparator used in the priority queue.
	 * 
	 */
	@Override
	public void run(V start) {
		HashMap<V, Integer> dist = new HashMap<V, Integer>(graph.numVertices());
		HashMap<V, V> pred = new HashMap<V, V>(graph.numVertices());
		HashSet<V> closed = new HashSet<V>();

		Iterator<V> iter = graph.iterator(); // create iterator over graph
		// add the starting vertex to the queue
		while (iter.hasNext()) { // while the iterator has another vertex
			V temp = iter.next(); // just a temp vertex
			dist.put(temp, Integer.MAX_VALUE); // add the vertex to the hash map and have its initial value be integer
												// max
			pred.put(temp, null); // put the temp vertex in the hashmap that keeps track of vertices that came
									// before.
		}
		dist.put(start, new Integer(0)); //

		// instantiating a comparator with a
		DiComparator test = new DiComparator(dist);
		PriorityQueue<V> open = new PriorityQueue<V>(graph.numVertices(), (Comparator<? super V>) test);
		open.add(start);
		while (open.isEmpty() == false) {
			V a = open.peek();
			if (a != null && !(dist.get(a) == Integer.MAX_VALUE)) {
				open.poll();
				closed.add(a);

				Iterator<? extends V> itera = graph.getNeighbors(a).iterator();
				while (itera.hasNext()) {
					V iteraVertex = itera.next();
					if (closed.contains(iteraVertex) == false) {
						int alternative = dist.get(a).intValue() + graph.getEdgeCost(a, iteraVertex);
						if (alternative < dist.get(iteraVertex)) {
							dist.replace(iteraVertex, alternative);
							pred.replace(iteraVertex, a);
							test.setDist(dist);//updates the comparator for the priority queue;
							
							int var = open.size();
							//make new priority queue with the new comparator
							PriorityQueue<V> temp = new PriorityQueue<V>(1000,(Comparator<? super V>) test);
							//copy over all the elements in the old comparator
							while(!open.isEmpty())
							{
								temp.add(open.poll());
							}
							open = temp;
							open.add(iteraVertex);
						}
					}
				}
			}
		}

		distances = dist;

		iter = graph.iterator(); // restarts the iterator
		// can just use dist and pred to get the distance at the node and the nodes
		// before it.
		int i = 0;// index of where we are going to put it into the List[]

		while (iter.hasNext()) {
			ArrayList<V> tempList = new ArrayList<V>(); // temporary arraylist of pred values.
			V endVertex = iter.next();
			V trackVertex = endVertex;
			tempList.add(endVertex); // adds the last node in the path to the temporary list
			// need to add the first node the iterator goes over, then go back through the
			// pred kev bullshit
			while  (pred.get(trackVertex) != null && (pred.get(trackVertex).equals(start) == false) )// while
																												// the
																												// tracking
																												// vertex
																												// value
																												// pair
																												// is
																												// not
																												// equal
																												// to
																												// the
																												// starting
																												// vertex
			{
				tempList.add(pred.get(trackVertex));// add the vertex that would be after the trackVertex in the path
				trackVertex = pred.get(trackVertex);// advance the track vertex in the path that leads back to the
													// starting vertex
			}
			tempList.add(start); // add the starting vertex the current list;
			// now we have to reverse the arraylist in order to get the path in order of
			// start --> the final vertex.

			ArrayList<V> reordered = new ArrayList<V>();
			for (int j = tempList.size() - 1; j >= 0; j--) // reverses the list
			{
				reordered.add(tempList.get(j));
			}

			lists[i] = reordered;
			i++;
		}
	}
	
	
	

	@Override
	public List<V> getShortestPath(V vertex) {
		for (int i = 0; i < lists.length; i++) {
			if (vertex.equals(lists[i].get(lists[i].size() - 1))) {
				return lists[i];
			}
		}
		return null;
	}

	@Override
	public int getShortestDistance(V vertex) {
		return distances.get(vertex).intValue();
	}

	class DiComparator implements Comparator<V> {

		public V adding;
		public Integer weight;
		public HashMap<V, Integer> dist;

		public DiComparator() {
		}

		public DiComparator(HashMap<V, Integer> dist) {
			this.dist = dist;
		}

		public DiComparator(V vert, Integer w) {
			adding = vert;
			weight = w;
		}

		public void setDist(HashMap<V, Integer> dist) {
			this.dist = dist;
		}

		@Override
		public int compare(V o1, V o2) {
			// TODO Auto-generated method stub
			int o1value = dist.get(o1).intValue();
			int o2value = dist.get(o2).intValue();

			if (o1value < o2value) {
				return -1;
			}
			if (o1value > o2value) {
				return 1;
			}
			return 0;
		}

	}
}