package cities;

public class City implements Comparable<City> {

	private String name;
	private Country country;
	private int population;

	public City(String name, Country country, int population) {
		this.name = name;
		this.country = country;
		this.population = population;
	}

	public String getName() {
		return name;
	}

	public Country getCountry() {
		return country;
	}

	public int getPopulation() {
		return population;
	}

	@Override
	public String toString() {
		return String.format("%s (of %s)", name, country.toString());
	}

	@Override
	public boolean equals(Object obj) {
		City city2 = (City) obj;
		return city2.getName().equals(name);
	}

	@Override
	public int compareTo(City other) {
		if (country.toString().compareTo(other.getCountry().toString()) == 0)
			return name.compareTo(other.getName());
		return country.toString().compareTo(other.getCountry().toString());
	}

}
