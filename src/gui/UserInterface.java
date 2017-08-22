package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import functionality.DegreeCelsius;
import functionality.DegreeFahrenheit;
import functionality.Kelvin;

/**
 * Creates the Interface of the application. The GUI is implemented via Java
 * Swing.
 * 
 * @author CM
 *
 */
@SuppressWarnings("serial")
public class UserInterface extends JFrame implements ActionListener {

	private JPanel panel;
	private JLabel inUnit;
	private JLabel value;
	private JComboBox<String> chooseInUnit;
	private JButton confirmButton;
	private JLabel outUnit1;
	private JLabel outUnit2;
	private JTextField entryValue;
	private JTextField outValue1;
	private JTextField outValue2;

	/**
	 * Constructor of the Interface. Creates the structure of the GUI.
	 * 
	 * @param title
	 *            Title of the JFrame.
	 * @param size1
	 *            Horizontal size of the JFrame.
	 * @param size2
	 *            Vertical size of the JFrame.
	 * @param color
	 *            Background color of the JPanel.
	 */
	public UserInterface(String title, int size1, int size2, Color color) {

		this.setTitle(title);
		this.setSize(size1, size2);

		panel = new JPanel();
		panel.setBackground(color);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 30));

		// Choose of the input unit
		inUnit = new JLabel("Ausgehende Einheit ");
		panel.add(inUnit);
		String comboBoxList[] = { "Kelvin", "Grad Celsius", "Grad Fahrenheit" };
		chooseInUnit = new JComboBox<>(comboBoxList);
		panel.add(chooseInUnit);

		// Entry of the converting value
		value = new JLabel("Wert ");
		panel.add(value);
		entryValue = new JTextField(14);
		panel.add(entryValue);
		confirmButton = new JButton("Okay");
		panel.add(confirmButton);
		confirmButton.addActionListener(this);

		// Output of the converting value
		outUnit1 = new JLabel("");
		panel.add(outUnit1);
		outValue1 = new JTextField("konvertierer Wert 1", 14);
		panel.add(outValue1);
		outUnit2 = new JLabel("");
		panel.add(outUnit2);
		outValue2 = new JTextField("konvertierer Wert 2", 14);
		panel.add(outValue2);

		this.add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	/**
	 * Functionality by using the interface.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.confirmButton) {

			if (!entryValue.getText().equals("")) {

				if (String.valueOf(this.chooseInUnit.getSelectedItem()).equals("Kelvin")) {

					Kelvin kelvin = new Kelvin();
					double celsiusValue = kelvin.convertToCelsius(Double.parseDouble(this.entryValue.getText()));
					double fahrenheitValue = kelvin.convertToFahrenheit(Double.parseDouble(this.entryValue.getText()));

					this.outUnit1.setText("Grad Celsius");
					this.outValue1.setText(String.valueOf(celsiusValue));
					this.outUnit2.setText("Grad Fahrenheit");
					this.outValue2.setText(String.valueOf(fahrenheitValue));
				} else if (String.valueOf(this.chooseInUnit.getSelectedItem()).equals("Grad Celsius")) {

					DegreeCelsius celsius = new DegreeCelsius();
					;
					double kelvinValue = celsius.convertToKelvin(Double.parseDouble(this.entryValue.getText()));
					double fahrenheitValue = celsius.convertToFahrenheit(Double.parseDouble(this.entryValue.getText()));

					this.outUnit1.setText("Kelvin");
					this.outValue1.setText(String.valueOf(kelvinValue));
					this.outUnit2.setText("Grad Fahrenheit");
					this.outValue2.setText(String.valueOf(fahrenheitValue));
				} else if (String.valueOf(this.chooseInUnit.getSelectedItem()).equals("Grad Fahrenheit")) {

					DegreeFahrenheit fahrenheit = new DegreeFahrenheit();
					double kelvinValue = fahrenheit.convertToKelvin(Double.parseDouble(this.entryValue.getText()));
					double celsiusValue = fahrenheit.convertToCelsius(Double.parseDouble(this.entryValue.getText()));

					this.outUnit1.setText("Kelvin");
					this.outValue1.setText(String.valueOf(kelvinValue));
					this.outUnit2.setText("Grad Celsius");
					this.outValue2.setText(String.valueOf(celsiusValue));
				}
			}
		}
	}
}
