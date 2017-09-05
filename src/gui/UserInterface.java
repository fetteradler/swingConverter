package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import functionality.DegreeRankine;
import functionality.DegreeRéaumur;
import functionality.Kelvin;
import tools.JFreeChartThermometer;

/**
 * Creates the Interface of the application. The GUI is implemented via Java
 * Swing.
 * 
 * @author CM
 *
 */
@SuppressWarnings("serial")
public class UserInterface extends JFrame implements ActionListener {

	private JFrame frame;
	private JPanel panel;
	private JLabel inUnit, value, outUnit1, outUnit2, outUnit3, outUnit4;
	private JComboBox<String> chooseInUnit;
	private JButton confirmButton, infoButton;
	private JTextField entryValue, outValue1, outValue2, outValue3, outValue4;
	private JMenuBar menuBar;
	private JMenu navigateMenu, colorMenu, settingsMenu;
	private JCheckBox advancedSettings, showChartThermometer;
	private JRadioButtonMenuItem colorItem1, colorItem2; // advancedSettings;
	private ButtonGroup buttonGroup;
	private GridBagConstraints gbc = new GridBagConstraints();

	/**
	 * Constructor of the interface. Create new object of UserInterface.
	 */
	public UserInterface() {

		frame = new JFrame("Converter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 950);

		this.createMenu();
		frame.setJMenuBar(menuBar);
		frame.add(createPanel(), BorderLayout.CENTER);

		frame.pack();
		frame.setVisible(true);

	}

	/**
	 * Create the JPanel of the interface. At this interface the whole GridBackLayout is defined. 
	 * @return Panel of the interface.
	 */
	public JPanel createPanel() {

		panel = new JPanel();
		panel.setBackground(Color.decode("#FFDEAD"));
		inUnit = new JLabel("Ausgehende Einheit");
		panel.setLayout(new GridBagLayout());
		String comboBoxList[] = { "Kelvin K", "Grad Celsius °C", "Grad Fahrenheit °F" };
		chooseInUnit = new JComboBox<>(comboBoxList);
		value = new JLabel("Wert ");
		entryValue = new JTextField(14);
		confirmButton = new JButton("Okay");
		outUnit1 = new JLabel("");
		outValue1 = new JTextField("Ausgabe 1", 14);
		outUnit2 = new JLabel("");
		outValue2 = new JTextField("Ausgabe 2", 14);
		infoButton = new JButton("<html><body>&#9432</bod></html>");

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

		outUnit3 = new JLabel("");
		gbc.gridx = 0;
		gbc.gridy = i;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(15, 15, 35, 15);
		gbc.fill = GridBagConstraints.NONE;
		panel.add(outUnit3, gbc);

		i++;
		outUnit4 = new JLabel("");
		gbc.gridx = 0;
		gbc.gridy = i;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(15, 15, 35, 15);
		gbc.fill = GridBagConstraints.NONE;
		panel.add(outUnit4, gbc);

		i++;
		i++;

		// JButton
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.LAST_LINE_START;
		gbc.gridy = i;
		gbc.insets = new Insets(25, 25, 45, 25);
		panel.add(infoButton, gbc);
		infoButton.addActionListener(this);

		i++;

		return panel;
	}

	/**
	 * Create the menubar of the application. The user can take different settings. 
	 */
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

				panel.setBackground(Color.decode("#FFDEAD"));
			}
		});

		settingsMenu = new JMenu("Einstellungen");
		advancedSettings = new JCheckBox("Erweiterte Funktionen");
		settingsMenu.add(advancedSettings);

		advancedSettings.addActionListener(new java.awt.event.ActionListener() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public void actionPerformed(java.awt.event.ActionEvent e) {

				if (advancedSettings.isSelected()) {
					String comboBoxList[] = { "Kelvin K", "Grad Celsius °C", "Grad Fahrenheit °F", "Grad Réaumur °Ré",
							"Grad Rankine °R" };
					chooseInUnit.setModel(new DefaultComboBoxModel(comboBoxList));

					outValue3 = new JTextField("Ausgabe 3", 14);
					outUnit3 = new JLabel("");
					outValue4 = new JTextField("Ausgabe 4", 14);
					outUnit4 = new JLabel("");

					// JTextField
					gbc.gridx = 1;
					gbc.gridy = 5;
					gbc.gridwidth = 2;
					gbc.insets = new Insets(15, 15, 35, 15);
					gbc.fill = GridBagConstraints.HORIZONTAL;
					panel.add(outValue3, gbc);

					// JLabel
					gbc.gridx = 0;
					gbc.gridy = 5;
					gbc.gridwidth = 1;
					gbc.insets = new Insets(15, 15, 35, 15);
					gbc.fill = GridBagConstraints.NONE;
					panel.add(outUnit3, gbc);

					// JTextField
					gbc.gridx = 1;
					gbc.gridy = 6;
					gbc.gridwidth = 2;
					gbc.insets = new Insets(15, 15, 35, 15);
					gbc.fill = GridBagConstraints.HORIZONTAL;
					panel.add(outValue4, gbc);

					// JLabel
					gbc.gridx = 0;
					gbc.gridy = 6;
					gbc.gridwidth = 1;
					gbc.insets = new Insets(15, 15, 35, 15);
					gbc.fill = GridBagConstraints.NONE;
					panel.add(outUnit4, gbc);
				}
				if (!advancedSettings.isSelected()) {
					String comboBoxList[] = { "Kelvin K", "Grad Celsius °C", "Grad Fahrenheit °F" };
					chooseInUnit.setModel(new DefaultComboBoxModel(comboBoxList));
					outValue3.setVisible(false);
					outUnit3.setVisible(false);
					outValue4.setVisible(false);
					outUnit4.setVisible(false);
				}
			}
		});
		
		showChartThermometer = new JCheckBox("Thermometer");
		settingsMenu.add(showChartThermometer);
		
		showChartThermometer.addActionListener(new java.awt.event.ActionListener() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public void actionPerformed(java.awt.event.ActionEvent e) {
				
				if(showChartThermometer.isSelected()) {
					JFreeChartThermometer panel = new JFreeChartThermometer();
					JFrame frame = new JFrame();
					frame.getContentPane().setLayout(new BorderLayout(5, 5));
				    frame.setDefaultCloseOperation(3);
				    frame.setTitle("Thermometer Test");
				    frame.getContentPane().add(panel, BorderLayout.CENTER);
				    frame.setSize(700, 400);
				    final Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
				    frame.setLocation((d.width - frame.getSize().width) / 2,
				                      (d.height - frame.getSize().height) / 2);
				    frame.setVisible(true);
				}
			}
		});

		menuBar.add(settingsMenu);
		menuBar.add(navigateMenu);
	}

	/**
	 * Functionality by using the interface. User can convert the entry in
	 * different units. Also the user can open an info window with different
	 * informations about the units. If the entry of the user is lower than 0K,
	 * an dialog window will open and brief the user about this.
	 */
	public void actionPerformed(ActionEvent e) {

		// If the button is pushed, the user converts the entry in different
		// equal units.
		if (e.getSource() == this.confirmButton) {

			if (!entryValue.getText().equals("")) {

				double kelvinValue = 0;
				double celsiusValue = 0;
				double fahrenheitValue = 0;
				double reaumurValue = 0;
				double rankinValue = 0;

				if (String.valueOf(this.chooseInUnit.getSelectedItem()).equals("Kelvin K")) {

					Kelvin kelvin = new Kelvin();
					try {
						kelvinValue = Double.parseDouble(this.entryValue.getText());
						celsiusValue = kelvin.convertToCelsius(Double.parseDouble(this.entryValue.getText()));
						fahrenheitValue = kelvin.convertToFahrenheit(Double.parseDouble(this.entryValue.getText()));

						this.outUnit1.setText("Grad Celsius °C");
						this.outValue1.setText(String.valueOf(celsiusValue));
						this.outUnit2.setText("Grad Fahrenheit °F");
						this.outValue2.setText(String.valueOf(fahrenheitValue));

						if (advancedSettings.isSelected()) {
							reaumurValue = kelvin.convertToRéaumur(Double.parseDouble(this.entryValue.getText()));
							rankinValue = kelvin.convertToRankine(Double.parseDouble(this.entryValue.getText()));
							this.outUnit3.setText("Grad Réaumur °Ré");
							this.outValue3.setText(String.valueOf(reaumurValue));
							this.outUnit4.setText("Grad Rankine °R");
							this.outValue4.setText(String.valueOf(rankinValue));
						}
					} catch (Exception ex) {

					}
				} else if (String.valueOf(this.chooseInUnit.getSelectedItem()).equals("Grad Celsius °C")) {

					DegreeCelsius celsius = new DegreeCelsius();
					try {
						kelvinValue = celsius.convertToKelvin(Double.parseDouble(this.entryValue.getText()));
						fahrenheitValue = celsius.convertToFahrenheit(Double.parseDouble(this.entryValue.getText()));

						this.outUnit1.setText("Kelvin K");
						this.outValue1.setText(String.valueOf(kelvinValue));
						this.outUnit2.setText("Grad Fahrenheit °F");
						this.outValue2.setText(String.valueOf(fahrenheitValue));
						if (advancedSettings.isSelected()) {
							reaumurValue = celsius.convertToRéaumur(Double.parseDouble(this.entryValue.getText()));
							rankinValue = celsius.convertToRankine(Double.parseDouble(this.entryValue.getText()));
							this.outUnit3.setText("Grad Réaumur °Ré");
							this.outValue3.setText(String.valueOf(reaumurValue));
							this.outUnit4.setText("Grad Rankine °R");
							this.outValue4.setText(String.valueOf(rankinValue));
						}
					} catch (Exception ex) {

					}
				} else if (String.valueOf(this.chooseInUnit.getSelectedItem()).equals("Grad Fahrenheit °F")) {

					DegreeFahrenheit fahrenheit = new DegreeFahrenheit();
					try {
						kelvinValue = fahrenheit.convertToKelvin(Double.parseDouble(this.entryValue.getText()));
						celsiusValue = fahrenheit.convertToCelsius(Double.parseDouble(this.entryValue.getText()));

						this.outUnit1.setText("Kelvin K");
						this.outValue1.setText(String.valueOf(kelvinValue));
						this.outUnit2.setText("Grad Celsius °C");
						this.outValue2.setText(String.valueOf(celsiusValue));
						if (advancedSettings.isSelected()) {
							reaumurValue = fahrenheit.convertToRéaumur(Double.parseDouble(this.entryValue.getText()));
							rankinValue = fahrenheit.convertToRankine(Double.parseDouble(this.entryValue.getText()));
							this.outUnit3.setText("Grad Réaumur °Ré");
							this.outValue3.setText(String.valueOf(reaumurValue));
							this.outUnit4.setText("Grad Rankine °R");
							this.outValue4.setText(String.valueOf(rankinValue));
						}
					} catch (Exception ex) {

					}
				} else if (String.valueOf(this.chooseInUnit.getSelectedItem()).equals("Grad Réaumur °Ré")) {

					DegreeRéaumur reaumur = new DegreeRéaumur();
					try {
						kelvinValue = reaumur.convertToKelvin(Double.parseDouble(this.entryValue.getText()));
						celsiusValue = reaumur.convertToCelsius(Double.parseDouble(this.entryValue.getText()));
						fahrenheitValue = reaumur.convertToFahrenheit(Double.parseDouble(this.entryValue.getText()));
						rankinValue = reaumur.convertToRankine(Double.parseDouble(this.entryValue.getText()));

						this.outUnit1.setText("Kelvin K");
						this.outValue1.setText(String.valueOf(kelvinValue));
						this.outUnit2.setText("Grad Celsius °C");
						this.outValue2.setText(String.valueOf(celsiusValue));
						this.outUnit3.setText("Grad Fahrenheit °F");
						this.outValue3.setText(String.valueOf(fahrenheitValue));
						this.outUnit4.setText("Grad Rankine °R");
						this.outValue4.setText(String.valueOf(rankinValue));
					} catch (Exception ex) {

					}
				} else if (String.valueOf(this.chooseInUnit.getSelectedItem()).equals("Grad Rankine °R")) {

					DegreeRankine rankine = new DegreeRankine();
					try {
						kelvinValue = rankine.convertToKelvin(Double.parseDouble(this.entryValue.getText()));
						celsiusValue = rankine.convertToCelsius(Double.parseDouble(this.entryValue.getText()));
						fahrenheitValue = rankine.convertToFahrenheit(Double.parseDouble(this.entryValue.getText()));
						reaumurValue = rankine.convertToRéaumur(Double.parseDouble(this.entryValue.getText()));

						this.outUnit1.setText("Kelvin K");
						this.outValue1.setText(String.valueOf(kelvinValue));
						this.outUnit2.setText("Grad Celsius °C");
						this.outValue2.setText(String.valueOf(celsiusValue));
						this.outUnit3.setText("Grad Fahrenheit °F");
						this.outValue3.setText(String.valueOf(fahrenheitValue));
						this.outUnit4.setText("Grad Réaumur °Ré");
						this.outValue4.setText(String.valueOf(reaumurValue));
					} catch (Exception ex) {

					}
				}

				// If the value is lower than 0K, the user getts an information.
				if (Kelvin.checkAbsoluteZero(kelvinValue) == false) {
					JDialog zeroWarning = new JDialog();
					zeroWarning.setTitle("Absoluter Nullpunkt");
					zeroWarning.setSize(200, 200);
					zeroWarning.setModal(true);
					zeroWarning.add(new JLabel(
							"<html><body>Ihr eingegebener Wert überschreitet den absoluten Nullpunkt der Erde.<br>Dieser liegt bei 0K.<br>Bitte beachten Sie dies bei Ihren weiterem Vorhaben.</body></html>"));
					zeroWarning.setVisible(true);
				}
			}
		}

		// If the button is pushed user get an information about the selected
		// unit.
		if (e.getSource() == this.infoButton) {

			JDialog infoDialog = new JDialog();
			infoDialog.setTitle("Info");
			infoDialog.setSize(300, 300);
			infoDialog.setModal(true);

			if (String.valueOf(this.chooseInUnit.getSelectedItem()).equals("Grad Rankine °R")) {

				infoDialog.add(new JLabel(
						"<html><body>Die Rankine-Skala ist eine Temperaturskala, die wie die Kelvin-Skala beim absoluten Temperaturnullpunkt ihren Nullwert hat, jedoch im Gegensatz zu dieser den Skalenabstand der Fahrenheit-Skala verwendet. Sie ist nach dem schottischen Ingenieur und Physiker William John Macquorn Rankine benannt, der sie im Jahre 1859 vorschlug (siehe auch die Rankine-Hugoniot-Gleichung). Sie wurde vor allem in anglophonen Ländern benutzt.<br><br><i>Quelle: Wikipedia</i></body></html>"));

			} else if (String.valueOf(this.chooseInUnit.getSelectedItem()).equals("Grad Fahrenheit °F")) {

				infoDialog.add(new JLabel(
						"<html><body>Grad Fahrenheit ist eine Maßeinheit der Temperatur. Sie wurde nach Daniel Gabriel Fahrenheit benannt.<br><br><i>Quelle: Wikipedia</i></body></html>"));
			} else if (String.valueOf(this.chooseInUnit.getSelectedItem()).equals("Grad Réaumur °Ré")) {

				infoDialog.add(new JLabel(
						"<html><body>Die Réaumur-Skala in Grad Réaumur (Einheitenzeichen: °Ré, °Re, °Réaumur, eingeschränkt auch °R) als Einheit zur Messung der Temperatur wurde 1730 vom französischen Naturforscher René-Antoine Ferchault de Réaumur eingeführt. Grad Réaumur ist keine SI-Einheit.<br>Bezugspunkte der Réaumur-Skala sind der Schmelzpunkt von Eis (0 °Ré) und der Siedepunkt von Wasser (80 °Ré) bei Normaldruck (1013,25 hPa). Réaumur nahm eine Einteilung zwischen diesen beiden Eckwerten in 80 gleiche Gradabstufungen vor.<br><br><i>Quelle: Wikipedia</i></body></html>"));
			} else if (String.valueOf(this.chooseInUnit.getSelectedItem()).equals("Grad Celsius °C")) {

				infoDialog.add(new JLabel(
						"<html><body>Das Grad Celsius ist eine Maßeinheit der Temperatur, welche nach Anders Celsius benannt wurde.<br><br><i>Quelle: Wikipedia</i></body></html>"));
			} else if (String.valueOf(this.chooseInUnit.getSelectedItem()).equals("Kelvin K")) {

				infoDialog.add(new JLabel(
						"<html><body>Das Kelvin (Einheitenzeichen: K) ist die SI-Basiseinheit der thermodynamischen Temperatur und zugleich gesetzliche Temperatureinheit. In vielen europäischen Ländern gilt daneben auch das Grad Celsius (Einheitenzeichen: °C) als gesetzliche Einheit für die Angabe von Celsius-Temperaturen und deren Differenzen. <br><br> <i>Quelle: Wikipedia</i> </body></html>"));
			}
			infoDialog.setVisible(true);
		}
	}

}
