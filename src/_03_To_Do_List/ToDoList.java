package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener, MouseListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 * 
	 * When add task is clicked: ask the user for a task and save it to an array
	 * list
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: prompt the user for which task to
	 * remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Prompt the user for the location of the
	 * file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */
	ArrayList<String> list = new ArrayList<String>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton add = new JButton("Add Task");
	JButton view = new JButton("View Task");
	JButton remove = new JButton("Remove Task");
	JButton save = new JButton("Save List");
	JButton load = new JButton("Load List");

	public ToDoList() {
		frame.add(panel);
		panel.add(add);
		panel.add(view);
		panel.add(remove);
		panel.add(save);
		panel.add(load);
		frame.setSize(250, 150);
		frame.setVisible(true);
		add.addActionListener(this);
		add.addMouseListener(this);
		view.addActionListener(this);
		remove.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// TODO Auto-generated method stub
		if (e.getSource().equals(add)) {
			String task = JOptionPane.showInputDialog("Add a task");
			list.add(task);
		}
		if (e.getSource().equals(view)) {
			JOptionPane.showConfirmDialog(null, list);
		}
		if (e.getSource().equals(remove)) {
			String test = JOptionPane.showInputDialog(null, "Which task would you like to remove" + list);
			list.remove(test);

		}
		if (e.getSource().equals(save)) {
			try {
				FileWriter fw = new FileWriter("src/_03_To_Do_List/ToDoList.txt");
				fw.append(list.toString());
				fw.close();
			} catch (IOException f) {
				// TODO: handle exception
				f.printStackTrace();
			}
		}
		if (e.getSource().equals(load)) {
			JFileChooser jfc = new JFileChooser();
			int returnVal = jfc.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				String file = jfc.getSelectedFile().getAbsolutePath();

				try {
					BufferedReader br = new BufferedReader(new FileReader("src/_03_To_Do_List/ToDoList.txt"));
					String line = br.readLine();
					while(line != null) {
						JOptionPane.showConfirmDialog(null, line);
						line = br.readLine();
					}
				} catch (FileNotFoundException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				} catch (IOException e3) {
					e3.printStackTrace();
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_03_To_Do_List/ToDoList.txt"));
			String line = br.readLine();
			list.add(line.substring(1, line.length() - 1));
		} catch (FileNotFoundException e2) {
			// TODO: handle exception
			e2.printStackTrace();
		} catch (IOException e3) {
			e3.printStackTrace();
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
