package cities;

public class City {

	private String name;
	private Road[] roads = new Road[10];
	private int numRoads, min, index;

	public City(String name) {
		this.name = name;
	}

	public void connect(Road r) {

		roads[numRoads++] = r;
	}

	public City nearestCity() {

		if (numRoads == 0)
			return null;
		else {
			min = roads[0].getLength();
			for (int i = 0; i < numRoads; i++) {
				if (roads[i].getLength() < min) {
					min = roads[i].getLength();
					index = i;
				}
			}
			if (roads[index].getCity1() == this)
				return roads[index].getCity2();
			else
				return roads[index].getCity1();

		}

	}

	public String toString() {

		return name;
	}

}
