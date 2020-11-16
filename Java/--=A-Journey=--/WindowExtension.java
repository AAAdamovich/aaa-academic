// Anton Adamovich
// Project Started: 12-13-12
// This Class Created: 12-13-12

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class WindowExtension extends JPanel{
	
	private ArrayList<Item> invenList = new ArrayList<Item>();
	
	public WindowExtension(Color backColor){
		setBackground(backColor);
	}

	public void setInvenList(ArrayList<Item> invenList) {
		this.invenList = invenList;
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.black);
		Font font = new Font("Times New Roman", Font.BOLD, 45);
		g.setFont(font);
		g.drawString("INVENTORY", 355, 45);
		g.setColor(Color.blue);
		Font font2 = new Font("Times New Roman", Font.PLAIN, 35);
		g.setFont(font2);
		
		// Row 1 Text
		g.drawString("Slot 1", 75, 100);
		g.drawString("Slot 2", 325, 100);
		g.drawString("Slot 3", 575, 100);
		g.drawString("Slot 4", 825, 100);
		
		// Row 2 Text
		g.drawString("Slot 5", 75, 270);
		g.drawString("Slot 6", 325, 270);
		g.drawString("Slot 7", 575, 270);
		g.drawString("Slot 8", 825, 270);
		g.setColor(Color.black);
		
		// Row 1 Box
		g.drawRect(15, 120, 200, 100);
		g.drawRect(265, 120, 200, 100);
		g.drawRect(515, 120, 200, 100);
		g.drawRect(765, 120, 200, 100);
		
		// Row 2 Box
		g.drawRect(15, 290, 200, 100);
		g.drawRect(265, 290, 200, 100);
		g.drawRect(515, 290, 200, 100);
		g.drawRect(765, 290, 200, 100);
		
		// Items
		Font font3 = new Font("Times New Roman", Font.PLAIN, 28);
		g.setFont(font3);
		int length = invenList.size();
		String[] items = new String[length];
		for (int i = 0; i <= (length - 1); i++){
			items[i] = ((invenList.get(i)).getName());
		}
		
		// First 4 slots
		boolean check = false;
		for (int i = 0; i <= 3; i++){
			for (int u = 0; u <= (((items[i]).length()) - 1); u++){
				if(!(items[i].equals(""))){
					if((items[i].charAt(u)) == ' '){
						g.drawString((items[i].substring(0, u)), ((i * 250) + 25), 150);
						g.drawString((items[i].substring(u + 1)), ((i * 250) + 25), 190);
						check = true;
					}
				}
			}
			if(!check) g.drawString((items[i]), ((i * 250) + 25), 150);
			check = false;
		}
		
		// Last 2 slots
		for (int i = 4; i <= 5; i++){
			for (int u = 0; u <= (((items[i]).length()) - 1); u++){
				if(!(items[i].equals(""))){
					if((items[i].charAt(u)) == ' '){
						g.drawString((items[i].substring(0, u)), (((i - 4) * 250) + 25), 320);
						g.drawString((items[i].substring(u + 1)), (((i - 4) * 250) + 25), 360);
					}
				}
			}
			if(!check) g.drawString((items[i]), (((i - 4) * 250) + 25), 320);
		}		
	}
}
