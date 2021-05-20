package cities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class World {

	private Map<String, Country> countries = new HashMap<>();

	public void addCountry(String name) {
		countries.put(name, new Country(name));
	}

	public void addCity(String name, String countryName, int population) {

		if (countries.get(countryName) == null)
			throw new IllegalArgumentException();

		countries.get(countryName).addCity(new City(name, countries.get(countryName), population));
	}

	public int population() {
		int sum = 0;

		for (Country c : countries.values())
			sum += c.population();

		return sum;
	}

	public List<City> smallCities(int under) {

		List<City> temp = new ArrayList<>();

		for (Country country : countries.values()) {
			for (City city : country.smallCities(under))
				temp.add(city);
		}
		return temp;
	}

	public String report() {
		StringBuilder toRet = new StringBuilder();
		for (Country country : countries.values()) {
			toRet.append(country.report());
			toRet.append("\n");
		}

		return toRet.toString() + "Total population is " + this.population() + "\n";
	}

}
