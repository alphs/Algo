public class Land{
	private String countryName;
	private String capital;
	private int population;
	private double area;

	public Land(String a, String b, int c, double d) {
		a = countryName;
		b = capital;
		c = population;
		d = area;
	}
	public String toString() {
		String temp = "countryName: " + countryName;
		temp = temp + "capital: " + capital;
		temp = temp + "population: " + population;
		temp = temp + "area: " + area;	
		return temp;
	}

	/** get functions to be able to access the variables outside of the class*/
	public String getCountryName() {
		return countryName;
	}

	public String getCapital() {
		return capital;
	}

	public int getPopulation() {
		return population;
	}

	public double getArea() {
		return area;
	}



}