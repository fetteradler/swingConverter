package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
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
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenu colorMenu;
	private JRadioButtonMenuItem colorItem1;
	private JRadioButtonMenuItem colorItem2;

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
		
		//Create GridBagLayout
		GridBagLayout gbl = new GridBagLayout();
		getContentPane().setLayout(gbl);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridheight = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.weightx = 1;
		gbc.weighty = 1;
		
		gbc.insets = new Insets(0,0,5,0);

		menuBar = new JMenuBar();
		
		gbl.setConstraints(menuBar, gbc);
		//getContentPane().add(menuBar);
		
		menu = new JMenu("Ansicht");
		colorMenu = new JMenu("Hintergrundfarbe anpassen");
		ButtonGroup buttonGroup = new ButtonGroup();
		colorItem1 = new JRadioButtonMenuItem("Grün", false);
		colorMenu.add(colorItem1);
		buttonGroup.add(colorItem1);
		colorItem2 = new JRadioButtonMenuItem("Beige", true);
		colorMenu.add(colorItem2);
		buttonGroup.add(colorItem2);
		menu.add(colorMenu);

		colorItem1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {

				panel.setBackground(Color.decode("#B4EEB4"));
			}
		});

		colorItem2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {

				panel.setBackground(Color.decode("#EED8AE"));
			}
		});

		// menu.add(colorItem);
		menuBar.add(menu);
		panel.add(menuBar, BorderLayout.NORTH);

		// Choose of the input unit
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,0,0,0);
		inUnit = new JLabel("Ausgehende Einheit ");
		
		gbl.setConstraints(inUnit, gbc);
		//getContentPane().add(inUnit);
		panel.add(inUnit);
		
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 3;
		gbc.insets = new Insets( 0, 5, 0, 5);
		String comboBoxList[] = { "Kelvin", "Grad Celsius", "Grad Fahrenheit" };
		chooseInUnit = new JComboBox<>(comboBoxList);
		gbl.setConstraints(chooseInUnit, gbc);
		//getContentPane().add(chooseInUnit);
		panel.add(chooseInUnit);

		// Entry of the converting value
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,0,0,0);
		gbc.weightx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		
		value = new JLabel("Wert ");
		
		gbl.setConstraints(value, gbc);
		//getContentPane().add(value);
		panel.add(value);
		

		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 3;
		gbc.insets = new Insets( 0, 5, 0, 5);
		entryValue = new JTextField(14);
		
		gbl.setConstraints(entryValue, gbc);
		//getContentPane().add(entryValue);
		panel.add(entryValue);
		
		//gbc.gridwidth = 1;
		//gbc.weightx = 1;
		//gbc.weighty = 1;

		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 3;
		gbc.insets = new Insets(0,5,0,5);
		
		gbc.fill = GridBagConstraints.NONE;
		confirmButton = new JButton("Okay");

		gbl.setConstraints(confirmButton, gbc);
		//getContentPane().add(confirmButton);
		panel.add(confirmButton);
		
		confirmButton.addActionListener(this);

		// Output of the converting value
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,0,0,0);
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.NONE;
		
		outUnit1 = new JLabel("");
		
		gbl.setConstraints(outUnit1, gbc);
		//getContentPane().add(outUnit1);
		panel.add(outUnit1);
		
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 3;
		gbc.insets = new Insets( 0, 5, 0, 5);
		outValue1 = new JTextField("konvertierer Wert 1", 14);
		gbl.setConstraints(outValue1, gbc);
		//getContentPane().add(outValue1);
		panel.add(outValue1);
		
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,0,0,0);
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.NONE;
		outUnit2 = new JLabel("");
		
		gbl.setConstraints(outUnit2, gbc);
		//getContentPane().add(outUnit2);
		panel.add(outUnit2);
		
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 3;
		gbc.insets = new Insets( 0, 5, 0, 5);
		outValue2 = new JTextField("konvertierer Wert 2", 14);
		gbl.setConstraints(outValue2, gbc);
		//getContentPane().add(outValue2);
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

				double kelvinValue = 0;
				double celsiusValue = 0;
				double fahrenheitValue = 0;

				if (String.valueOf(this.chooseInUnit.getSelectedItem()).equals("Kelvin")) {

					Kelvin kelvin = new Kelvin();
					try {
						kelvinValue = Double.parseDouble(this.entryValue.getText());
						celsiusValue = kelvin.convertToCelsius(Double.parseDouble(this.entryValue.getText()));
						fahrenheitValue = kelvin
								.convertToFahrenheit(Double.parseDouble(this.entryValue.getText()));

						this.outUnit1.setText("Grad Celsius");
						this.outValue1.setText(String.valueOf(celsiusValue));
						this.outUnit2.setText("Grad Fahrenheit");
						this.outValue2.setText(String.valueOf(fahrenheitValue));
					} catch (Exception ex) {

					}
				} else if (String.valueOf(this.chooseInUnit.getSelectedItem()).equals("Grad Celsius")) {

					DegreeCelsius celsius = new DegreeCelsius();
					try {
						kelvinValue = celsius.convertToKelvin(Double.parseDouble(this.entryValue.getText()));
						fahrenheitValue = celsius
								.convertToFahrenheit(Double.parseDouble(this.entryValue.getText()));

						this.outUnit1.setText("Kelvin");
						this.outValue1.setText(String.valueOf(kelvinValue));
						this.outUnit2.setText("Grad Fahrenheit");
						this.outValue2.setText(String.valueOf(fahrenheitValue));
					} catch (Exception ex) {

					}
				} else if (String.valueOf(this.chooseInUnit.getSelectedItem()).equals("Grad Fahrenheit")) {

					DegreeFahrenheit fahrenheit = new DegreeFahrenheit();
					try {
						kelvinValue = fahrenheit.convertToKelvin(Double.parseDouble(this.entryValue.getText()));
						celsiusValue = fahrenheit
								.convertToCelsius(Double.parseDouble(this.entryValue.getText()));

						this.outUnit1.setText("Kelvin");
						this.outValue1.setText(String.valueOf(kelvinValue));
						this.outUnit2.setText("Grad Celsius");
						this.outValue2.setText(String.valueOf(celsiusValue));
					} catch (Exception ex) {

					}
				}
				
				if (Kelvin.checkAbsoluteZero(kelvinValue) == false) {
					JDialog zeroWarning = new JDialog();
					zeroWarning.setTitle("Absoluter Nullpunkt");
					zeroWarning.setSize(200, 200);
					zeroWarning.setModal(true);
					zeroWarning.add(new JLabel(
							"<html><body>Ihr eingegebener Wert überschreitet den absoluten Nullpunkt der Erde.<br>Bitte beachten Sie dies bei Ihren weiterem Vorhaben.</body></html>"));
					zeroWarning.setVisible(true);
				}
			}
		}
	}
}
