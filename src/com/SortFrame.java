/******************************************************************
 * Name           : Palaniappan Ramiah, Mounika Porandla
 * ZID            : Z1726972, Z1719789
 * Assignment No. : 3
 * Program Name   : SortFrame.java
 * Description    : Contains the GUI part with constructors, sets
 * 					frame's properties, adds sort panel objects.
 *****************************************************************/
package com;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JFrame;

public class SortFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	// Creating objects
	SortPanel leftSortPaneObj;
	SortPanel rightSortPaneObj;

	public SortFrame(Container pane) {

		super("Sorting Animation");

		// Initializing the objects
		leftSortPaneObj = new SortPanel(pane);
		rightSortPaneObj = new SortPanel(pane);

		// Adding Buttons
		leftSortPaneObj.sortPanel.add(leftSortPaneObj.arrayButton);
		leftSortPaneObj.sortPanel.add(leftSortPaneObj.sortButton);
		leftSortPaneObj.sortPanel.add(leftSortPaneObj.sortingBox);

		rightSortPaneObj.sortPanel.add(rightSortPaneObj.arrayButton);
		rightSortPaneObj.sortPanel.add(rightSortPaneObj.sortButton);
		rightSortPaneObj.sortPanel.add(rightSortPaneObj.sortingBox);

	}

	/**
	 * main() method which handles all the user interaction thru GUI and Call
	 * methods of MileRedeemer class by creating a object instance.
	 * 
	 * @param args
	 *            []
	 * @return null
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception {

		// Swing Utility method to synchronize with the user's action
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				// Creating a new Frame.
				JFrame frame = new JFrame();

				// Setting the container's properties
				frame.setSize(710, 380);
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("Sorting Animation");
				frame.setLayout(new GridLayout(0, 2, 5, 5));
				frame.getContentPane().setBackground(Color.white);

				new SortFrame(frame);
			}
		});
	}
}