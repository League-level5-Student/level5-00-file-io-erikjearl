package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 * 
	 * When add task is clicked:
	 * 		ask the user for a  task and save it to an array list
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list.
	 */
	JFrame frame;
	JPanel panel;
	
	JButton add;
	JButton view;
	JButton remove;
	JButton save;
	JButton load;
	
	ArrayList<String> lst;
	
	public static void main(String[] args) {
		ToDoList todo = new ToDoList();
		todo.makeGUI();
	}
	
	public void makeGUI() {
		lst = new ArrayList<String>();
		frame = new JFrame();
		panel = new JPanel();
		add = new JButton("add");
		view = new JButton("view");
		remove = new JButton("remove");
		save = new JButton("save");
		load= new JButton("load");
		
		add.addActionListener(this);
		view.addActionListener(this);
		remove.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
		
		frame.add(panel);
		panel.add(add);
		panel.add(view);
		panel.add(remove);
		panel.add(save);
		panel.add(load);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == add) {
			lst.add(JOptionPane.showInputDialog("message?"));
		}
		if(e.getSource() == view) {
			for(String s : lst) {
				System.out.println(s);
			}
			System.out.println("-------");
		}
		if(e.getSource() == remove) {
			String rm = JOptionPane.showInputDialog("remove?");
			for(int i = 0; i < lst.size(); i++) {
				if(rm.equals(lst.get(i))) {
					lst.remove(i);
				}
			}
		}
		if(e.getSource() == save) {
			try {
				FileWriter fw = new FileWriter("src/_03_To_Do_List/text.txt");
				for(String s : lst) {
				fw.write(s + "\n");
				}
				fw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource() == load) {
			String file = JOptionPane.showInputDialog("file name?");
			try {
				BufferedReader br = new BufferedReader(new FileReader("src/_03_To_Do_List/" + file));
				
				String line = br.readLine();
				while(line != null){
					System.out.println(line);
					line = br.readLine();
				}
				br.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
	}
	
	
	
}
