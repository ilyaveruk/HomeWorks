package cities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Country implements Comparable<Country> {

	private Set<City> cities = new TreeSet<>();
	private String name;

	public Country(String name) {
		this.name = name;
	}

	public void addCity(City city) {
		if (city.getCountry().toString().compareTo(name) != 0)
			throw new IllegalArgumentException();
		this.cities.add(city);
	}

	public int population() {
		int sum = 0;

		for (City c : cities)
			sum += c.getPopulation();

		return sum;
	}

	public String toString() {
		return name;
	}

	public List<City> smallCities(int under) {
		List<City> temp = new ArrayList<>();

		for (City c : cities)
			if (c.getPopulation() < under)
				temp.add(c);

		return temp;
	}

	public String report() {
		StringBuilder stringToRet=new StringBuilder();
		stringToRet.append(name);
		stringToRet.append("(");
		stringToRet.append(this.population());
		stringToRet.append(") :");
		for(City cityTemp : cities) {
			stringToRet.append(" ");
			stringToRet.append(cityTemp.getName());
			stringToRet.append("(");
			stringToRet.append(cityTemp.getPopulation());
			stringToRet.append("),");
		}
		stringToRet.deleteCharAt(stringToRet.toString().length()-1);
		return stringToRet.toString();
	}

	@Override
	public boolean equals(Object obj) {
		Country country2 = (Country) obj;
		return country2.toString().equals(name);
	}

	@Override
	public int compareTo(Country o) {
		return o.toString().compareTo(name);
	}

}
