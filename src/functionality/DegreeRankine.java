package functionality;

public class DegreeRankine {

	/**
	 * Convert a value in degree Rankine to the equal value in degree Celsius.
	 * 
	 * @param value
	 *            Value in degree Rankine that wants to be converted. Rounded up
	 *            to 2 decimal places.
	 * @return converted degree Celsius value
	 */
	public double convertToCelsius(double value) {

		double result;
		result = (value - 491.67) * 0.55556;
		
		//round up result to 2 decimal places
		double roundResult = Math.round(result * 100.0) / 100.0;

		return roundResult;
	}
	
	/**
	 * Convert a value in degree Rankine to the equal value in degree Fahrenheit.
	 * 
	 * @param value
	 *            Value in degree Rankine that wants to be converted. Rounded up to 2
	 *            decimal places.
	 * @return converted degree Fahrenheit value
	 */
	public double convertToFahrenheit(double value) {

		double result;

		result = value - 459.67;

		double roundResult = Math.round(result * 100.0) / 100.0;

		return roundResult;
	}
	
	/**
	 * Convert a value in degree Rankine to the equal value in Kelvin.
	 * 
	 * @param value
	 *            Value in degree Rankine that wants to be converted. Rounded up
	 *            to 2 decimal places.
	 * @return converted Kelvin value
	 */
	public double convertToKelvin(double value) {

		double result;

		result = value * 0.55556;
		
		//round up result to 2 decimal places
		double roundResult = Math.round(result * 100.0) / 100.0;

		return roundResult;
	}
	
	/**
	 * Convert a value in degree Rankine to the equal value in degree
	 * Réaumur.
	 * 
	 * @param value
	 *            Value in degree Rankine that wants to be converted. Rounded up
	 *            to 2 decimal places.
	 * @return converted degree Réaumur value
	 */
	public double convertToRéaumur(double value) {
		
		double result;
		
		result = (value - 491.67) * 0.44444;
		
		double roundResult = Math.round(result * 100.0) / 100.0;

		return roundResult;
	}
}
