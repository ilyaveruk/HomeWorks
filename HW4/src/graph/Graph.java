package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph<V> {

	private Set<V> vertices = new HashSet<>();
	private Map<V, Set<V>> edges = new HashMap<>();

	public void addVertex(V v) throws GraphException {
		if (vertices.contains(v))
			throw new GraphException("Vertex already exists");
		vertices.add(v);

		Set<V> connectedVertics = new HashSet<>();// creating empty set
		edges.put(v, connectedVertics);
	}

	public void addEdge(V v1, V v2) throws GraphException {
		if (edges.containsKey(v2) && edges.containsKey(v1)) {
			if (this.hasEdge(v1, v2))
				throw new GraphException("Edge already exists");
			else {
				edges.get(v1).add(v2);
				edges.get(v2).add(v1);
			}
		} else
			throw new GraphException("One or noth vertices are not exist");

	}

	public boolean hasEdge(V v1, V v2) {
		if (edges.containsKey(v1) && edges.containsKey(v2))
			if (edges.get(v1).contains(v2))
				return true;
		return false;
	}

	public boolean connected(V v1, V v2) throws GraphException {
		if (vertices.contains(v1) == false || vertices.contains(v2) == false)
			throw new GraphException("One of the vertices does not exist");

		Set<V> verticesChecked = new HashSet<>();
		return rucFunToCheckConnect(v1, v2, verticesChecked);
	}

	private boolean rucFunToCheckConnect(V v1, V v2, Set<V> verticesChecked) {

		if (verticesChecked.contains(v1) == true)
			return false;
		
		verticesChecked.add(v1);
		
		if (v1.equals(v2))
			return true;
		
		Set<V> neighbors = edges.get(v1);
		for (V v : neighbors) {
			if (rucFunToCheckConnect(v, v2, verticesChecked)) {
				return true;
			}
		}
		return false;
	}

}
