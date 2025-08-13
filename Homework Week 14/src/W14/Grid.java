package W14;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Grid extends JFrame{

	private static final long serialVersionUID = 1L;
	private static String text, unsortedVal, modeValues;
	private static String[] temp1;
	private static Double[] parsed;
	private static double numOfValues, sum, mid;
	public static boolean sortAct=false, meanAct=false, midAct=false, modeAct=false, fileOpened=false;
	private static int fileToOpen, fileToSave;
	JFileChooser fileOpen;
	JFileChooser fileSave;
	JFrame notice;
	File txt;
	
	
	
	public static JTextArea textArea = new JTextArea();
	public Grid() {
		MenuBar menuBar = new MenuBar();
		setMenuBar(menuBar);
		Menu file = new Menu("File");
		menuBar.add(file);
		MenuItem open = new MenuItem("Open");
		MenuItem values = new MenuItem("Unsorted and sorted values");
		MenuItem mean = new MenuItem("Mean");
		MenuItem median = new MenuItem("Median");
		MenuItem mode = new MenuItem("Mode");
		MenuItem save = new MenuItem("Save Results");
		MenuItem close = new MenuItem("Exit");
		file.add(open);
		file.add(values);
		file.add(mean);
		file.add(median);
		file.add(mode);
		file.add(save);
		file.add(close);
		getContentPane().add(textArea);
		textArea.setText(" \u2191\u2191\u2191 Select a .txt file using the Open option.");
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);


		open.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				openFile();
				if (fileToOpen == JFileChooser.APPROVE_OPTION){
					fileOpened=true;
					sortAct=false;
					meanAct=false;
					midAct=false;
					modeAct=false;
					textArea.setText("");
					try{
						Scanner scan = new Scanner(new FileReader(fileOpen.getSelectedFile().getPath()));
						while (scan.hasNext()) {
							textArea.append(scan.nextLine());
						}
						text=textArea.getText();
					} catch (IOException ex){
						System.out.println(ex.getMessage());
					}
				}
			}
		});
		
		values.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(fileOpened==true) {
					temp1 = text.split(";");
					parsed = new Double[temp1.length];
					for (int i = 0; i<temp1.length; i++) {
						parsed[i] = Double.valueOf(temp1[i]);
					}
					
					unsortedVal=Arrays.toString(temp1);
					
					List<Double> sortedVal = Arrays.asList(parsed); 
					Collections.sort(sortedVal);
					
					textArea.setText("Unsorted values: "+unsortedVal+"\n\nSorted values: "+sortedVal);
					sortAct=true;
					meanAct=false;
					midAct=false;
					modeAct=false;
					}
				else {
					JFrame notice=new JFrame();
					JOptionPane.showMessageDialog(notice,"Please open a text file.","Notice",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		mean.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(fileOpened==true) {
				temp1 = text.split(";");
				for(String i: temp1) {
					numOfValues++;
					Double.parseDouble(i);
					sum= sum +Double.parseDouble(i);
				}
				textArea.setText("Average: "+ sum/numOfValues);
				sortAct=false;
				meanAct=true;
				midAct=false;
				modeAct=false;
				}
				else {
					JFrame notice=new JFrame();
					JOptionPane.showMessageDialog(notice,"Please open a text file.","Notice",JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		
		median.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(fileOpened==true) {
					temp1 = text.split(";");
					parsed = new Double[temp1.length];
					for (int i = 0; i<temp1.length; i++) {
						parsed[i] = Double.valueOf(temp1[i]);
					}
					List<Double> sortedVal = Arrays.asList(parsed);
					Collections.sort(sortedVal);
					
					if (sortedVal.size()%2 == 1) {
						mid = (sortedVal.get(sortedVal.size()/2) + sortedVal.get(sortedVal.size()/2 - 1))/2;
					}
					else {
						mid = sortedVal.get(sortedVal.size()/2);
					}
						
					textArea.setText("Median: "+mid);
					sortAct=false;
					meanAct=false;
					midAct=true;
					modeAct=false;
					}
				else {
					JFrame notice=new JFrame();
					JOptionPane.showMessageDialog(notice,"Please open a text file.","Notice",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		mode.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(fileOpened==true) {
					temp1 = text.split(";");
					parsed = new Double[temp1.length];
					for (int i = 0; i<temp1.length; i++) {
						parsed[i] = Double.valueOf(temp1[i]);
					}
					mode(parsed);
					textArea.setText("Mode/s: "+modeValues);
					sortAct=false;
					meanAct=false;
					midAct=false;
					modeAct=true;
				}
				else {
					JFrame notice=new JFrame();
					JOptionPane.showMessageDialog(notice,"Please open a text file.","Notice",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		close.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				saveFile();
				if (fileToSave == JFileChooser.APPROVE_OPTION && fileOpened==true) {
					try {
						if(sortAct==true){	
							FileWriter out = new FileWriter(new File(fileSave.getSelectedFile().getPath(), "value.txt"));
							out.write(textArea.getText());
							out.close();
						}
						else if(meanAct == true) {
							FileWriter out = new FileWriter(new File(fileSave.getSelectedFile().getPath(), "mean.txt"));
							out.write(textArea.getText());
							out.close();
						}
						else if(midAct == true) {	 	
							FileWriter out = new FileWriter(new File(fileSave.getSelectedFile().getPath(), "median.txt"));
							out.write(textArea.getText());
							out.close();
						}
						else if(modeAct==true) {
							FileWriter out = new FileWriter(new File(fileSave.getSelectedFile().getPath(), "mode.txt"));
							out.write(textArea.getText());
							out.close();
						}
					}
					catch (IOException ex) {
						System.out.println(ex.getMessage());
					}
				}
				else if(fileToSave == JFileChooser.APPROVE_OPTION && fileOpened==false) {
					JFrame notice=new JFrame();
					JOptionPane.showMessageDialog(notice,"Please open a text file.","Notice",JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
	}
	private static void mode(Double[] parsed) {
		HashMap<Double, Double> counter = new HashMap<Double, Double>();
		for (double d : parsed) {
			Double count = counter.get(d);
			counter.put(d, (count == null ? 1 : count + 1));
	}
		List<Double> mode = new ArrayList<Double>();
		List<Double> frequency = new ArrayList<Double>();
		List<Double> values = new ArrayList<Double>();

		
		for (Entry<Double, Double> entry : counter.entrySet()) {
			frequency.add(entry.getValue());
			values.add(entry.getKey());
		}
		double maxCount = Collections.max(frequency);

		for(int i=0; i< frequency.size();i++)
		{
			double val =frequency.get(i);
			if(maxCount == val )
			{
				mode.add(values.get(i));
			}
		}
		Double[] temp2 = mode.toArray( new Double[mode.size()]);
		modeValues=Arrays.toString(temp2);
		return;
	}
	
	public void openFile(){
		JFileChooser open = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt(text files)", "txt");
		open.setAcceptAllFileFilterUsed(false);
		open.addChoosableFileFilter(filter);
		int option = open.showOpenDialog(this);
		fileToOpen = option;
		fileOpen = open;
	}
	
	public void saveFile(){
		JFileChooser save = new JFileChooser();
		save.setDialogTitle("Choose a directory to save your file: ");
		save.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int option = save.showSaveDialog(null);
		fileToSave = option;
		fileSave = save;
	}
}
