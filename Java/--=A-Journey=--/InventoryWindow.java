// Anton Adamovich
// Project Started: 12-13-12
// This Class Created: 12-13-12

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

public class InventoryWindow {
	public static void makeWindow(ArrayList<Item> invenList){
		JFrame theGUI = new JFrame();
		theGUI.setTitle("Inventory");
		theGUI.setSize(1000, 800);
		theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		WindowExtension panel = new WindowExtension(Color.lightGray);
		panel.setInvenList(invenList);
		Container pane = theGUI.getContentPane();
		pane.add(panel);
		theGUI.setVisible(true);	
	}
}
