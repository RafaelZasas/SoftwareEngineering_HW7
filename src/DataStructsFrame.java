import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.*;

public class DataStructsFrame extends JFrame {
	public DataStructsFrame(String title) {
		super(title);

		final JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));


		final ListPanel unorderedList = new ListPanel("Unordered List");
		unorderedList.setDiameter(75);


		final ListPanel orderedList = new ListPanel("Ordered List");
		orderedList.setDiameter(100);

		JButton sortButton = new JButton("Sort List");
		sortButton.setSize(30, 10);
		sortButton.setAlignmentX(CENTER_ALIGNMENT);

		JTextField input = new JTextField(); // INPUT FOR THE USER TO ENTER A VALUES
		input.setToolTipText("Enter the values you wish to sort here");
		input.requestFocus();

		sortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String Input = input.getText();  //  GETS THE INPUT FROM THE USER
				String [] n = Input.split(" ");  // BREAKS UP THE INPUT INTO AN ARRAY OF NUMBER STRINGS
				int[] numbers= new int[n.length];  // INT ARRAY TO STORE THE PARSED NUMBERS
				ArrayList<ListItem> list;  // CREATE A LIST TO STORE THE UNORDERED NUMBERS

				for (int i = 0; i < n.length; i++) {
					numbers[i]= Integer.parseInt(n[i]);  // PARSE THE STRINGS AND STORE IN NUMBERS ARRAY
				}

				list = arrayToList(numbers);  // PASSES THE INPUTTED UNORDERED NUMBERS TO THE ARRAYS TO LIST METHOD
				unorderedList.removeAll();  // CLEARS THE LIST SO ONLY 1 IS POPULATED UPON BTN CLICK
				unorderedList.addItems(list);  // ADD THE ITEMS TO THE UNORDERED LIST
				panel.add(unorderedList); // ADD THE UNORDERED LIST TO THE PANEL

				Arrays.sort(numbers);  // sorts the given array
				int[] desc =new int[numbers.length];  // creates a new array of the same size for desc numbers

				int count=0;
				for (int i = numbers.length-1; i >-1 ; i--) {  //  TASK 3: reverses the sorted array
					desc[count]=numbers[i];
					count++;
				}

				ArrayList<ListItem> desc_list = arrayToList(desc); // passes the descended int array to an array list


				orderedList.removeAll(); // TASK 2: CLEARS THE ORDERED LIST SO ONLY 1 APPEARS UPON BTN CLICK

				orderedList.addItems(desc_list);
				panel.add(orderedList);
				pack();
			}
		});

		panel.add(input);

		panel.add(sortButton);
		add(panel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	private ArrayList<ListItem> arrayToList(int[] numbers) {


		ArrayList<ListItem> list = new ArrayList<ListItem>();

		for (int i = 0; i < numbers.length; i++) {
			ListItem item = new ListItem(numbers[i],i); // NUMBERS PASSES THE ARRAY AND i IS PASSED AS THE INDEX
			list.add(item);
		}

		return list;
	}
}
