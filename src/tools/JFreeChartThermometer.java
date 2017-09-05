package tools;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.JThermometer;
import org.jfree.chart.plot.MeterPlot;
import org.jfree.data.general.DefaultValueDataset;

@SuppressWarnings("serial")
public class JFreeChartThermometer extends JPanel {

	private DefaultValueDataset data = new DefaultValueDataset(20.0);
	
	private MeterPlot meterplot = new MeterPlot(this.data);

	private JFreeChart meterchart = new JFreeChart("Meter Chart", JFreeChart.DEFAULT_TITLE_FONT, this.meterplot, false);

	private JButton update = new JButton();
	
	private GridLayout gridLayout1 = new GridLayout();
	
	private JThermometer thermometer1 = new JThermometer();
	private JThermometer thermometer2 = new JThermometer();
	private JThermometer thermometer3 = new JThermometer();
	private JThermometer[] thermometer = new JThermometer[3];
	
	public JFreeChartThermometer() {
	    try {
	      thermometerIni();
	    }
	    catch (Exception ex) {
	      ex.printStackTrace();
	    }
	  }

	private void thermometerIni() throws Exception {
		
		this.setBackground(Color.white);
		
		this.thermometer[0] = this.thermometer1;
	    this.thermometer[1] = this.thermometer2;
	    this.thermometer[2] = this.thermometer3;
	    
	    this.thermometer[0].setBackground(Color.white);
	    this.thermometer[1].setBackground(Color.white);
	    this.thermometer[2].setBackground(Color.white);

	    this.thermometer[0].setValue(0.0);
	    this.thermometer[1].setValue(0.2);
	    this.thermometer[2].setValue(0.3);
	    
	    this.thermometer[0].setUnits(2);
	    this.thermometer[1].setUnits(1);
	    this.thermometer[2].setUnits(0);
	    
	    this.thermometer[0].addSubtitle("Grad Celsius");
	    this.thermometer[1].addSubtitle("Grad Fahrenheit");
	    this.thermometer[2].addSubtitle("Kelvin");
	    
	    this.thermometer[0].setShowValueLines(true);
	    this.thermometer[0].setFollowDataInSubranges(true);
	    this.thermometer[1].setValueLocation(1);
	    
	    this.thermometer[0].setRange(-10.0, 40.0);
	    //this.thermometer[0].setSubrangeInfo(range, rangeLow, rangeHigh, displayLow, displayHigh);
	    
	    this.thermometer[0].setValueFormat(new DecimalFormat("#0.00"));
	    this.thermometer[1].setValueFormat(new DecimalFormat("#0.00"));
	    this.thermometer[2].setValueFormat(new DecimalFormat("#0.00"));
	    
	    thermometer1.setPreferredSize(new Dimension(200, 300));
	    this.add(thermometer1, BorderLayout.LINE_START);
	    thermometer2.setPreferredSize(new Dimension(200, 300));
	    this.add(thermometer2, BorderLayout.CENTER);
	    thermometer3.setPreferredSize(new Dimension(200, 300));
	    this.add(thermometer3, BorderLayout.LINE_END);
	    update.setText("Aktualisieren");
	    this.add(update, BorderLayout.PAGE_END);
	    
	}

	public JFreeChart getMeterchart() {
		return meterchart;
	}

	public void setMeterchart(JFreeChart meterchart) {
		this.meterchart = meterchart;
	}

	public GridLayout getGridLayout1() {
		return gridLayout1;
	}

	public void setGridLayout1(GridLayout gridLayout1) {
		this.gridLayout1 = gridLayout1;
	}
	
//	 public static void main(final String[] args) {
//
//		    final JFreeChartThermometer panel = new JFreeChartThermometer();
//
//		    final JFrame frame = new JFrame();
//		    frame.getContentPane().setLayout(new BorderLayout(5, 5));
//		    frame.setDefaultCloseOperation(3);
//		    frame.setTitle("Thermometer Test");
//		    frame.getContentPane().add(panel, BorderLayout.CENTER);
//		    frame.setSize(700, 400);
//		    final Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
//		    frame.setLocation((d.width - frame.getSize().width) / 2,
//		                      (d.height - frame.getSize().height) / 2);
//		    frame.setVisible(true);
//
//		  }
}
