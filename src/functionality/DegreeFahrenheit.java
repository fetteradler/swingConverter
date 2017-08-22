package functionality;

/**
 * Functions for an value in degree Fahrenheit. 
 * @author CM
 *
 */
public class DegreeFahrenheit {

	/**
	 * Convert a value in degree Fahrenheit to the equal value in degree Celsius.
	 * 
	 * @param value
	 *            Value in degree Fahrenheit that wants to be converted. Rounded up
	 *            to 2 decimal places.
	 * @return converted degree Celsius value
	 */
	public double convertToCelsius(double value) {

		double result;

		result = (value - 32) / 1.8;
		
		//round up result to 2 decimal places
		double roundResult = Math.round(result * 100.0) / 100.0;

		return roundResult;
	}

	/**
	 * Convert a value in degree Fahrenheit to the equal value in Kelvin.
	 * 
	 * @param value
	 *            Value in degree Fahrenheit that wants to be converted. Rounded up
	 *            to 2 decimal places.
	 * @return converted Kelvin value
	 */
	public double convertToKelvin(double value) {

		double result;

		result = (value + 459.67) / 1.8;
		
		//round up result to 2 decimal places
		double roundResult = Math.round(result * 100.0) / 100.0;

		return roundResult;
	}
}
