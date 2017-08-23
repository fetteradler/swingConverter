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

@SuppressWarnings("serial")
public class LayoutInterface extends JFrame implements ActionListener {

	private JFrame frame;
	private JPanel panel;
	private JLabel inUnit, value, outUnit1, outUnit2;
	private JComboBox<String> chooseInUnit;
	private JButton confirmButton, adjustmentButton;
	private JTextField entryValue, outValue1, outValue2;
	private JMenuBar menuBar;
	private JMenu navigateMenu, colorMenu;
	private JRadioButtonMenuItem colorItem1, colorItem2;
	private ButtonGroup buttonGroup;

	public LayoutInterface() {

		frame = new JFrame("Converter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 650);

		// LayoutInterface lI = new LayoutInterface();
		// lI.createMenu();
		this.createMenu();
		frame.setJMenuBar(menuBar);
		frame.add(createPanel(), BorderLayout.CENTER);

		frame.pack();
		frame.setVisible(true);

	}

	public JPanel createPanel() {

		panel = new JPanel();
		panel.setBackground(Color.decode("#FFDEAD"));
		inUnit = new JLabel("Ausgehende Einheit");
		panel.setLayout(new GridBagLayout());
		String comboBoxList[] = { "Kelvin", "Grad Celsius", "Grad Fahrenheit" };
		chooseInUnit = new JComboBox<>(comboBoxList);
		value = new JLabel("Wert ");
		entryValue = new JTextField(14);
		confirmButton = new JButton("Okay");
		outUnit1 = new JLabel("");
		outValue1 = new JTextField("konvertierer Wert 1", 14);
		outUnit2 = new JLabel("");
		outValue2 = new JTextField("konvertierer Wert 2", 14);
		adjustmentButton = new JButton("Einstellungen");

		GridBagConstraints gbc = new GridBagConstraints();
		int i = 0;
		// JComboBox
		gbc.gridx = 1;
		gbc.gridy = i;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(15, 15, 15, 15);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel.add(chooseInUnit, gbc);

		// JLabel
		gbc.gridx = 0;
		gbc.gridy = i;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(15, 15, 15, 15);
		gbc.fill = GridBagConstraints.NONE;
		panel.add(inUnit, gbc);

		i++;

		// JTextField
		gbc.gridx = 1;
		gbc.gridy = i;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(5, 15, 5, 15);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel.add(entryValue, gbc);

		// JLabel
		gbc.gridx = 0;
		gbc.gridy = i;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(5, 15, 5, 15);
		gbc.fill = GridBagConstraints.NONE;
		panel.add(value, gbc);

		i++;

		// JButton
		// gbc.anchor = GridBagConstraints.BASELINE;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridy = i;
		gbc.insets = new Insets(25, 25, 45, 25);
		panel.add(confirmButton, gbc);
		confirmButton.addActionListener(this);

		i++;

		// JTextField
		gbc.gridx = 1;
		gbc.gridy = i;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(15, 15, 35, 15);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel.add(outValue1, gbc);

		// JLabel
		gbc.gridx = 0;
		gbc.gridy = i;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(15, 15, 35, 15);
		gbc.fill = GridBagConstraints.NONE;
		panel.add(outUnit1, gbc);

		i++;

		// JTextField
		gbc.gridx = 1;
		gbc.gridy = i;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(15, 15, 35, 15);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel.add(outValue2, gbc);

		// JLabel
		gbc.gridx = 0;
		gbc.gridy = i;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(15, 15, 35, 15);
		gbc.fill = GridBagConstraints.NONE;
		panel.add(outUnit2, gbc);

		i++;

		// JButton
		// gbc.anchor = GridBagConstraints.BASELINE;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.LAST_LINE_START;
		gbc.gridy = i;
		gbc.insets = new Insets(25, 25, 45, 25);
		panel.add(adjustmentButton, gbc);
		adjustmentButton.addActionListener(this);

		i++;
		
		return panel;
	}

	public void createMenu() {

		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		navigateMenu = new JMenu("Ansicht");
		colorMenu = new JMenu("Hintergrundfarbe anpassen");
		buttonGroup = new ButtonGroup();

		colorItem1 = new JRadioButtonMenuItem("Grün", false);
		colorMenu.add(colorItem1);
		buttonGroup.add(colorItem1);

		colorItem2 = new JRadioButtonMenuItem("Beige", true);
		colorMenu.add(colorItem2);
		buttonGroup.add(colorItem2);

		navigateMenu.add(colorMenu);

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

		menuBar.add(navigateMenu);
	}

	/**
	 * Functionality by using the interface.
	 */
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
						fahrenheitValue = kelvin.convertToFahrenheit(Double.parseDouble(this.entryValue.getText()));

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
						fahrenheitValue = celsius.convertToFahrenheit(Double.parseDouble(this.entryValue.getText()));

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
						celsiusValue = fahrenheit.convertToCelsius(Double.parseDouble(this.entryValue.getText()));

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
