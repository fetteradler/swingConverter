package functionality;

public class DegreeRéaumur {

	/**
	 * Convert a value in degree Réaumur to the equal value in degree Celsius.
	 * 
	 * @param value
	 *            Value in degree Réaumur that wants to be converted. Rounded up
	 *            to 2 decimal places.
	 * @return converted degree Celsius value
	 */
	public double convertToCelsius(double value) {

		double result;

		result = value / 0.8;
		
		//round up result to 2 decimal places
		double roundResult = Math.round(result * 100.0) / 100.0;

		return roundResult;
	}
	
	/**
	 * Convert a value in degree Réaumur to the equal value in Kelvin.
	 * 
	 * @param value
	 *            Value in degree Réaumur that wants to be converted. Rounded up
	 *            to 2 decimal places.
	 * @return converted Kelvin value
	 */
	public double convertToKelvin(double value) {

		double result;

		result = (value * 1.25) + 273.15;
		
		//round up result to 2 decimal places
		double roundResult = Math.round(result * 100.0) / 100.0;

		return roundResult;
	}
	
	/**
	 * Convert a value in degree Réaumur to the equal value in degree
	 * Fahrenheit.
	 * 
	 * @param value
	 *            Value in degree Réaumur that wants to be converted. Rounded up
	 *            to 2 decimal places.
	 * @return converted degree Fahrenheit value
	 */
	public double convertToFahrenheit(double value) {

		double result;

		result = 2.25 * value + 32;

		// round up result to 2 decimal places
		double roundResult = Math.round(result * 100.0) / 100.0;

		return roundResult;
	}
	
	/**
	 * Convert a value in degree Réaumur to the equal value in degree
	 * Rankine.
	 * 
	 * @param value
	 *            Value in degree Réaumur that wants to be converted. Rounded up
	 *            to 2 decimal places.
	 * @return converted degree Rankine value
	 */
	public double convertToRankine(double value) {
		
		double result;
		
		result = value * 2.25 + 491.67;
		
		double roundResult = Math.round(result * 100.0) / 100.0;

		return roundResult;
	}
}
