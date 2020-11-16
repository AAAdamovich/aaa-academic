//Anton Adamovich
//AP Computer Science A
//Mr. Meistering
//8-30-12
//Project 2-7

import javax.swing.*;
import java.awt.*;

public class Grid {

	public static void main(String[] args) {

		// Object Declarations

		JFrame GUI = new JFrame();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		JPanel panel6 = new JPanel();
		JPanel panel7 = new JPanel();
		JPanel panel8 = new JPanel();
		JPanel panel9 = new JPanel();
		Container pane = GUI.getContentPane();

		// GUI Settings

		GUI.setTitle("Mini-Chessboard");
		GUI.setSize(300, 200);
		GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUI.setVisible(true);

		// Panel Settings

		panel1.setBackground(Color.black);
		panel2.setBackground(Color.white);
		panel3.setBackground(Color.black);
		panel4.setBackground(Color.white);
		panel5.setBackground(Color.black);
		panel6.setBackground(Color.white);
		panel7.setBackground(Color.black);
		panel8.setBackground(Color.white);
		panel9.setBackground(Color.black);

		// Pane Settings

		pane.setLayout(new GridLayout(3, 3));
		pane.add(panel1);
		pane.add(panel2);
		pane.add(panel3);
		pane.add(panel4);
		pane.add(panel5);
		pane.add(panel6);
		pane.add(panel7);
		pane.add(panel8);
		pane.add(panel9);

	}

}
