package TestFactory;

public class America implements FactoryMethod {

	@Override
	public Countries createCountriesBy(String cityName) {
		switch(cityName.toLowerCase()) {
		case "guatemala":
		return new Guatemala();
		case "new york":
			return new NewYork();
		case "los_angeles":
			return new California();
		case "chicago":
			return new Chicago();
			default:
				throw new IllegalArgumentException("Unknown  City: " + cityName);
	}}

}
