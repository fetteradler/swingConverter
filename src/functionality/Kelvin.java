package functionality;

/**
 * Functions for an value in Kelvin.
 * 
 * @author CM
 *
 */
public class Kelvin {

	/**
	 * Convert a value in Kelvin to the equal value in degree Fahrenheit.
	 * 
	 * @param value
	 *            Value in Kelvin that wants to be converted. Rounded up to 2
	 *            decimal places.
	 * @return converted degree Fahrenheit value
	 */
	public double convertToFahrenheit(double value) {

		double result;

		result = value * 1.8 - 459.67;

		// round up result to 2 decimal places
		double roundResult = Math.round(result * 100.0) / 100.0;

		return roundResult;
	}

	/**
	 * Convert a value in Kelvin to the equal value in degree Celsius.
	 * 
	 * @param value
	 *            Value in Kelvin that wants to be converted. Rounded up to 2
	 *            decimal places.
	 * @return converted degree Celsius value
	 */
	public double convertToCelsius(double value) {

		double result;

		result = value - 273.15;

		// round up result to 2 decimal places
		double roundResult = Math.round(result * 100.0) / 100.0;

		return roundResult;
	}

	/**
	 * Checks if the entered value is not lower than the absolute zero.
	 * 
	 * @param value
	 *            Entered value of Kelvin to check if the absolute zero is
	 *            beyond.
	 * @return True if value is >= 0, false if not.
	 */
	public static boolean checkAbsoluteZero(double value) {

		if (value >= 0) {
			return true;
		} else {
			return false;
		}
	}
}
