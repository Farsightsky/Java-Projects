import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.BreakIterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Grid extends JFrame{

	private static final long serialVersionUID = 1L;
	static int letterCount, wordCount, sentenceCount;
	static String wordFrequency, charFrequency, sortedWords,text,words, temp1;
	static String[] temp, split;
	int fileToOpen, fileToSave;
	JFileChooser fileOpen;
	JFileChooser fileSave;
	JFrame notice;
	static JTextArea textArea = new JTextArea();
	String originalText = String.valueOf(textArea.getText());
	String editedText;
	BreakIterator iterator;
	public Grid() {
		
		MenuBar menuBar = new MenuBar();
		setMenuBar(menuBar);
		Menu file = new Menu("File");
		menuBar.add(file);
		MenuItem newOption = new MenuItem("New");
		MenuItem open = new MenuItem("Open");
		MenuItem save = new MenuItem("Save");
		MenuItem close = new MenuItem("Exit");
		MenuItem statistics = new MenuItem("Statistics");
		file.add(newOption);
		file.add(open);
		file.add(save);
		file.add(statistics);
		file.add(close);
		getContentPane().add(textArea);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int confirmed = JOptionPane.showConfirmDialog(notice, "Are you sure you want to exit the program?", "Notice", JOptionPane.YES_NO_OPTION);
				if (confirmed == JOptionPane.YES_OPTION) {
					dispose();
				}
				else {
					 setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});
		
		newOption.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				textArea.setText("");
			}
		});

		open.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				openFile();
				if (fileToOpen == JFileChooser.APPROVE_OPTION){
					textArea.setText("");
					try{
						Scanner scan = new Scanner(new FileReader(fileOpen.getSelectedFile().getPath()));
						while (scan.hasNext())
							textArea.append(scan.nextLine());
					} catch (IOException ex){
						System.out.println(ex.getMessage());
					}
				}
			}
		});
		
		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				saveFile();
				editedText = String.valueOf(textArea.getText());
				if (originalText.equals(editedText)) {
					int output = JOptionPane.showConfirmDialog(null, "The text is unedited. Are you sure that you want to save?");
					if(output==JOptionPane.YES_OPTION){  
							try {
								BufferedWriter out = new BufferedWriter(new FileWriter(fileSave.getSelectedFile().getPath()));
								out.write(textArea.getText());
								out.close();
							} catch (IOException ex) {
								System.out.println(ex.getMessage());
						}
					}
					else if(output==JOptionPane.NO_OPTION) {
					}
					else {
					}
				}
				else if (!(originalText.equals(editedText)) ) {
					try {
						BufferedWriter out = new BufferedWriter(new FileWriter(fileSave.getSelectedFile().getPath()));
						out.write(textArea.getText());
						out.close();
					} catch (IOException ex) {
						System.out.println(ex.getMessage());
					}
				}
			}
		});
		
		statistics.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				text=textArea.getText();
				sentenceCount=0;
				for (int i = 0; i < text.length(); i++) {
					if(text.charAt(i)=='.'||text.charAt(i)=='!'||text.charAt(i)=='?'||text.charAt(i)==',') {
						sentenceCount++;
							}
						}
				letterCount = text.replaceAll("\\s","").length();
				wordCount = text.split("\\s").length;
				wordFrequency = counter(text.split("\\s")).entrySet().stream()
						.map(s -> s.getKey() + ": " + s.getValue())
						.collect(Collectors.joining("\n"));
				charFrequency = counter(text.replaceAll("\\s","").split("")).entrySet().stream()
						.map(s -> s.getKey() + " : " + s.getValue())
						.collect(Collectors.joining("\n"));
				words = counter(text.split("\\s")).entrySet().stream()
						.map(s -> s.getKey()).collect(Collectors.joining(" "));
				split =words.split("\\s");
				for (int i = 0; i < split.length; i++) {
					for (int j = i + 1; j < split.length; j++) {
						if (split[i].compareTo(split[j])>0) 
						{
							temp1 = split[i];
							split[i] = split[j];
							split[j] = temp1;
						}
					}
				}
				StringBuffer sb = new StringBuffer();
				for(int i = 0; i < split.length; i++) {
					sb.append(split[i]+" ");
				}
				sortedWords = sb.toString();
				JFrame frame2 = new helper();
				JScrollPane yScroll=new JScrollPane(helper.stats);
				frame2.add(yScroll);
				frame2.setTitle("Statistics");
				frame2.setVisible(true);
				frame2.setSize(350, 400);
				frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame2.setResizable(true);
				frame2.setLocationRelativeTo(null);
			}
		});

		close.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
	}
	
	public static Map<String, Integer> counter(String[] words) {
		Map<String, Integer> map = new HashMap<String, Integer> ();
		for (String r:words) {
			if (!map.containsKey(r)) {
				map.put(r, 1);
			}
			else {
				int count = map.get(r);
				map.put(r, count + 1);
			}
		}		
	return map;
	}
	
	public void openFile(){
		JFileChooser open = new JFileChooser();
		int option = open.showOpenDialog(this);
		fileToOpen = option;
		fileOpen = open;
	}

	public void saveFile(){
		JFileChooser save = new JFileChooser();
		int option = save.showOpenDialog(this);
		fileToSave = option;
		fileSave = save;
	}
}
