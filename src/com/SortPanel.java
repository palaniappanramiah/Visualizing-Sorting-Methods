/******************************************************************
 * Name           : Palaniappan Ramiah, Mounika Porandla
 * ZID            : Z1726972, Z1719789
 * Assignment No. : 3
 * Program Name   : SortPanel.java
 * Description    : Contains the method to populate the array
 * 					and sort them.
 *****************************************************************/

package com;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class SortPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	// Fields Declaration
	String[] sortingMethods = { "Selection", "Bubble", "Quick", "Insertion",
			"Merge" };
	int[] populateArray = null;
	int populateArraySize = 0, panelWidth = 0, panelHeight = 0;

	// Creating new panel
	JPanel animationPanel = new JPanel();
	JPanel sortPanel = new JPanel();
	JPanel oldPanel = new JPanel();

	// Creating buttons
	JButton arrayButton = new JButton("Populate Array");
	JButton sortButton = new JButton("Sort");
	JComboBox sortingBox = new JComboBox(sortingMethods);

	// Creating instance of the objects of the sorting classes
	InsertionSort insertionSort = new InsertionSort();
	BubbleSort bubbleSort = new BubbleSort();
	MergeSort mergeSort = new MergeSort();
	QuickSort quickSort = new QuickSort();
	SelectionSort selectionSort = new SelectionSort();

	SortAnimationPanel sortAnimationPanel = new SortAnimationPanel();

	public SortPanel(final Container pane) {

		sortButton.setEnabled(false);

		// Setting the layout
		animationPanel.setLayout(new BorderLayout());
		animationPanel.add(sortPanel, BorderLayout.SOUTH);

		// Setting background colors and layout for the panes
		pane.add(animationPanel);

		arrayButton.addActionListener(new ActionListener() {
			// Method that is invoked when the populate array button is clicked
			public void actionPerformed(ActionEvent arg0) {

				// Creating the Array
				final int populateArraySize = animationPanel.getWidth() - 1;
				populateArray = new int[populateArraySize];
				Random rand = new Random();

				for (int index = 0; index < populateArraySize; index++) {
					int randomNumber = rand.nextInt(populateArraySize);
					populateArray[index] = randomNumber;
				}

				animationPanel.repaint();

				// Adding a panel and drawing lines
				animationPanel.add(new JPanel() {
					public void paintComponent(Graphics graphics) {
						super.paintComponent(graphics);
						graphics.setColor(Color.blue);

						panelWidth = animationPanel.getWidth() - 1;

						if (populateArray != null) {
							for (int i = 0; i < panelWidth; i++) {
								graphics.drawLine(i, panelWidth, i,
										populateArray[i]);
							}
						}

					}
				});

				// Setting the pane's properties
				pane.setBackground(Color.white);
				pane.setVisible(true);

				// Setting the button's properties
				sortButton.setEnabled(true);
				arrayButton.setEnabled(false);
			}
		});

		sortButton.addActionListener(new ActionListener() {
			// Method that is invoked when the sort button is clicked
			public void actionPerformed(ActionEvent arg0) {
				// To get the sorting method value
				String selectedItem = (String) sortingBox.getSelectedItem();
				if (selectedItem.equals("Insertion"))
					populateArray = insertionSort
							.doInsertionSort(populateArray);
				else if (selectedItem.equals("Bubble"))
					populateArray = bubbleSort.doBubbleSort(populateArray);
				else if (selectedItem.equals("Merge"))
					populateArray = mergeSort.doMergeSort(populateArray);
				else if (selectedItem.equals("Quick"))
					populateArray = quickSort.doQuicksort(populateArray);
				else if (selectedItem.equals("Selection"))
					populateArray = selectionSort
							.doSelectionSort(populateArray);

				// Changing animationPanel's properties
				animationPanel.removeAll();
				animationPanel.setLayout(new BorderLayout());

				// Adding a panel and drawing the sorted lines
				animationPanel.add(new JPanel() {
					public void paintComponent(Graphics graphics) {

						super.paintComponent(graphics);
						graphics.setColor(Color.blue);

						panelWidth = animationPanel.getWidth() - 1;

						if (populateArray != null) {
							int j = panelWidth - 1;
							for (int i = 0; i < panelWidth; i++) {
								graphics.drawLine(i, panelWidth, i,
										populateArray[j]);
								j--;
							}
						}
					}
				});

				// Adding back the buttons
				oldPanel.add(arrayButton);
				oldPanel.add(sortButton);
				oldPanel.add(sortingBox);

				animationPanel.add(oldPanel, BorderLayout.SOUTH);

				// Setting the button's properties
				sortButton.setEnabled(false);
				arrayButton.setEnabled(true);

				// Setting the pane's properties
				pane.setVisible(true);
			}
		});

	}

	private class SortAnimationPanel extends JPanel implements Runnable {

		private static final long serialVersionUID = 1L;

		public void run() {
			// Creating a thread
			Thread thread = new Thread();
			thread.start();
			try {
				thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
