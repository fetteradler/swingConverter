package starter;

import gui.LayoutInterface;

/**
 * Main of the program. Start the application.
 * 
 * @author CM
 *
 */
public class Run {

	/**
	 * Creates a new object of UserInterface.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

//		UserInterface ui = new UserInterface("Converter", 350, 400, Color.decode("#FFDEAD"));
//		ui.setVisible(true);
		
//		SwingUtilities.invokeLater(new Runnable() {
//
//			@Override
//			public void run() {
//				LayoutInterface.layout();
//			}
//		});
		
		LayoutInterface ial = new LayoutInterface();
	}
}
