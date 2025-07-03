package TestFactory;

public class Europe implements FactoryMethod {

	@Override
	public Countries createCountriesBy(String cityName) {
		switch(cityName.toLowerCase()) {
		case "warsaw":
			return new Warsaw();
		
		case "berlin":
		return new Berlin();
		case "moscow":
			return new Moskow();
		case "paris":
			return new Paris();
		case "rome":
			return new Rome();
		default: 
				throw new IllegalArgumentException("Unknown European City: " + cityName);
	
	}
	}
}
