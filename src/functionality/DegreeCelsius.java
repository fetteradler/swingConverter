package functionality;

/**
 * Functions for an value in degree Celsius.
 * 
 * @author CM
 *
 */
public class DegreeCelsius {

	/**
	 * Convert a value in degree Celsius to the equal value in Kelvin.
	 * 
	 * @param value
	 *            Value in degree Celsius that wants to be converted. Rounded up
	 *            to 2 decimal places.
	 * @return converted Kelvin value
	 */
	public double convertToKelvin(double value) {

		double result;

		result = value + 273.15;

		// round up result to 2 decimal places
		double roundResult = Math.round(result * 100.0) / 100.0;

		return roundResult;
	}

	/**
	 * Convert a value in degree Celsius to the equal value in degree
	 * Fahrenheit.
	 * 
	 * @param value
	 *            Value in degree Celsius that wants to be converted. Rounded up
	 *            to 2 decimal places.
	 * @return converted degree Fahrenheit value
	 */
	public double convertToFahrenheit(double value) {

		double result;

		result = value * 1.8 + 32;

		// round up result to 2 decimal places
		double roundResult = Math.round(result * 100.0) / 100.0;

		return roundResult;
	}
}
