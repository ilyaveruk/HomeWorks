package graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Maze implements GraphInterface<Place> {

	private int size;
	private Place start, end;
	private Place[][] mazeMat;
	private Set<Place> walls = new HashSet<>();

	public Maze(int size, int startx, int starty, int endx, int endy) {
		end = new Place(endx, endy, size);
		start = new Place(startx, starty, size);
		this.size = size;
		mazeMat = new Place[size][size];
	}

	public boolean addWall(int x, int y) {
		Place wall = new Place(x, y, size);

		if (wall.equals(start) || wall.equals(end))
			throw new IllegalArgumentException();
		if (mazeMat[x][y] != null)
			return false;
		mazeMat[x][y] = wall;
		walls.add(wall);
		return true;
	}

	public String toString() {
		StringBuilder stringToRet = new StringBuilder();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {

				if (i == start.getX() && j == start.getY())
					stringToRet.append("S");
				else if (i == end.getX() && j == end.getY())
					stringToRet.append("E");
				else if (mazeMat[i][j] == null)// empty
					stringToRet.append(".");
				else
					stringToRet.append("@");// wall
			}
			stringToRet.append("\n");
		}
		return stringToRet.toString();
	}

	public boolean isSolvable() {
		Graph<Place> graph = new Graph<>();
		Place p1, p2;
		try {
			for (int i = 0; i < size; i++)
				for (int j = 0; j < size; j++)
					if (mazeMat[i][j] == null)
						graph.addVertex(new Place(i, j, size));
			for (int i = 0; i < size; i++)
				for (int j = 0; j < size; j++) {

					if (i + 1 >= 0 && i + 1 < size && j >= 0 && j < size && walls.contains(mazeMat[i + 1][j]) == false
							&& walls.contains(mazeMat[i][j]) == false) {
						p2 = new Place(i, j, size);
						p1 = new Place(i + 1, j, size);
						graph.addEdge(p1, p2);
					}
					if (i >= 0 && i < size && j + 1 >= 0 && j + 1 < size && walls.contains(mazeMat[i][j + 1]) == false
							&& walls.contains(mazeMat[i][j]) == false) {
						p2 = new Place(i, j, size);
						p1 = new Place(i, j + 1, size);
						graph.addEdge(p1, p2);
					}
				}
			if (graph.connected(start, end) == true)
				return true;
		} catch (GraphException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Collection<Place> neighbours(Place p) {
		int x = p.getX();
		int y = p.getY();
		Place neighbour;
		List<Place> neighborsList = new ArrayList<Place>();

		if (x + 1 >= 0 && x + 1 < size && y >= 0 && y < size
				&& walls.contains(neighbour = new Place(x + 1, y, size)) == false)
			neighborsList.add(neighbour);

		if (x - 1 >= 0 && x - 1 < size && y >= 0 && y < size
				&& walls.contains(neighbour = new Place(x - 1, y, size)) == false)
			neighborsList.add(neighbour);

		if (x >= 0 && x < size && y - 1 >= 0 && y - 1 < size
				&& walls.contains(neighbour = new Place(x, y - 1, size)) == false)
			neighborsList.add(neighbour);

		if (x >= 0 && x < size && y + 1 >= 0 && y + 1 < size
				&& walls.contains(neighbour = new Place(x, y + 1, size)) == false)
			neighborsList.add(neighbour);

		return neighborsList;
	}

}
