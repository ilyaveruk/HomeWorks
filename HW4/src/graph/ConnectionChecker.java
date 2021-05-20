package graph;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ConnectionChecker<V> {

	private GraphInterface<V> graph;

	public ConnectionChecker(GraphInterface<V> g) {
		this.graph = g;
	}

	public boolean check(V v1, V v2) {
		if (graph.neighbours(v1) == null || graph.neighbours(v2) == null) {
			return false;
		}
		Set<V> verticesCheked = new HashSet<>();
		return rucFunToCheckConnect(v1, v2, verticesCheked);
	}

	private boolean rucFunToCheckConnect(V v1, V v2, Set<V> verticesCheked) {

		if (verticesCheked.contains(v1) == true)
			return false;
		verticesCheked.add(v1);
		if (v1.equals(v2) == true)
			return true;
		Collection<V> neighbors = graph.neighbours(v1);
		for (V v : neighbors) {
			if (rucFunToCheckConnect(v, v2, verticesCheked)) {
				return true;
			}
		}
		return false;
	}

}
