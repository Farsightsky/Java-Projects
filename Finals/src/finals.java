import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class finals extends JFrame{

	/**
	 * 
	 */
	
	private boolean loadAct=false, error=false, CMSC11=false, CMSC12=false,CMSC55=false,Math53=false,Math54=false,Math55=false,CMSC116=false,CMSC123=false, Physics101=false, Physics102=false,CMSC131=false,CMSC125=false;
	private static final long serialVersionUID = 1L;
	private JFrame frame, load;
	private JTable freSem1, freSem2, sopSem1, sopSem2, junSem1, junSem2, senSem1, senSem2;							//fre=freshman, sop=sophomore, jun=junior, sen=senior
	private Object[][] fir1, fir2, sec1, sec2, thi1, thi2, fou1, fou2;												//fir=first, sec=second...
	private static int fileToOpen, fileToSave;
	private static String str=null,lineSep, temp, PEAct;
	private static String[] lines;
	JFileChooser fileOpen, fileSave;
	private JLabel lblFirstYear, lblSecondYear, lblThirdYear, lblFourthYear;
	private JLabel lblFirstSemester;
	private JLabel lblSecondSemester;
	private JLabel lblStudentName;
	private JLabel lblNewLabel_3;
	private JTextField textFieldName;
	private JTextField textFieldID;
	/**	
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					finals window = new finals();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public finals() {
		initialize();
	}
	
	
	private void initialize() {
		frame = 	new JFrame();
		frame.setBounds(100, 100, 800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		MenuBar menuBar = new MenuBar();
		frame.setMenuBar(menuBar);
		Menu file = new Menu("File");
		menuBar.add(file);
		MenuItem load = new MenuItem("Load");
		MenuItem save = new MenuItem("Save ");
		MenuItem close = new MenuItem("Exit");
		file.add(load);
		file.add(save);
		file.add(close);
		LinkedHashMap<String, String> courseGrade = new LinkedHashMap<>();
		LinkedHashMap<String, String> courseSection = new LinkedHashMap<>();
		
		ArrayList<String> valGra= new ArrayList<>();							//valGra=validGrades
		valGra.add("1.0");
		valGra.add("1.25");
		valGra.add("1.5");
		valGra.add("1.75");
		valGra.add("2.0");
		valGra.add("2.25");
		valGra.add("2.5");
		valGra.add("2.75");
		valGra.add("3.0");
		valGra.add("4.0");
		valGra.add("5.0");
		valGra.add("inc");
		valGra.add("drp");
		
		
		load.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				loadAct=true;
				CMSC11=false;CMSC12=false;CMSC55=false;Math53=false;Math54=false;Math55=false;CMSC116=false;CMSC123=false;Physics101=false;Physics102=false;CMSC131=false;CMSC125=false;
				JFileChooser open = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt(text files)", "txt");
				open.setAcceptAllFileFilterUsed(false);
				open.addChoosableFileFilter(filter);
				int option = open.showOpenDialog(finals.this);
				fileToOpen = option;
				fileOpen = open;
				if (fileToOpen == JFileChooser.APPROVE_OPTION){
					try{
						FileReader fr= new FileReader(fileOpen.getSelectedFile().getPath());
						BufferedReader br	 = new BufferedReader(fr);
						StringBuilder sb = new StringBuilder();
						lineSep = System.getProperty("line.separator");
						while ((str = br.readLine()) != null) {
							sb.append(str);
							sb.append(lineSep);
						}

						sb.deleteCharAt(sb.length() - 1);
						br.close();

						temp = sb.toString();

						int infoTrim=2;
						lines = temp.split("\r\n");
						String[][] matrix = new String[lines.length][];
						int rowSize = 0;
						for (String row : lines) {
							matrix[rowSize++] = row.split(",", 4);
						}

						for(int i=0;i<lines.length-infoTrim;i++) {
							courseSection.put(matrix[i+infoTrim][0], matrix[i+infoTrim][1]);
							courseGrade.put(matrix[i+infoTrim][0], matrix[i+infoTrim][3]);
						}
						
					} catch (IOException ex){
						System.out.println(ex.getMessage());
					}
					textFieldID.setText(lines[0]);
					textFieldName.setText(lines[1]);
					for(int i=0;i<8-1;i++) {
						
					}
					for(int i=0;i<8-1;i++) {
						freSem1.getModel().setValueAt(courseSection.get(freSem1.getModel().getValueAt(i+1,0)),i+1,1);
						freSem1.getModel().setValueAt(courseGrade.get(freSem1.getModel().getValueAt(i+1,0)),i+1,2);
					}
					
					if(courseSection.get("CMSC 11")!=null && courseGrade.get("CMSC 11")!=null) {
						CMSC11=true;
					}
					
					if(courseSection.get("CMSC 12")!=null && courseGrade.get("CMSC 12")!=null && CMSC11==true) {			//for CMSC 110, CMSC 131 and CMSC 123
						freSem2.getModel().setValueAt(courseSection.get("CMSC 12"),1,1);
						freSem2.getModel().setValueAt(courseGrade.get("CMSC 12"),1,2);
						CMSC12=true;
					}
					
					if(courseSection.get("CMSC 55")!=null && courseGrade.get("CMSC 55")!=null) {			//for CMSC 123
						freSem2.getModel().setValueAt(courseSection.get("CMSC 55"),2,1);
						freSem2.getModel().setValueAt(courseGrade.get("CMSC 55"),2,2);
						CMSC55=true;
					}
					
					if(courseSection.get("CMSC 130")!=null && courseGrade.get("CMSC 130")!=null && CMSC11==true) {
						freSem2.getModel().setValueAt(courseSection.get("CMSC 130"),3,1);
						freSem2.getModel().setValueAt(courseGrade.get("CMSC 130"),3,2);
					}
					
					if(courseSection.get("Math 53")!=null) {
						Math53=true;
					}
					
					if(courseSection.get("Math 54")!=null && courseGrade.get("Math 54")!=null && Math53==true) {
						freSem2.getModel().setValueAt(courseSection.get("Math 54"),4,1);
						freSem2.getModel().setValueAt(courseGrade.get("Math 54"),4,2);
						Math54=true;
					}
					
					if(courseSection.get("Ethics 1")!=null && courseGrade.get("Ethics 1")!=null){
						freSem2.getModel().setValueAt(courseSection.get("Ethics 1"),5,1);
						freSem2.getModel().setValueAt(courseGrade.get("Ethics 1"),5,2);
					}
					
					if(courseSection.get("PE 2 Pentaque")!=null && courseGrade.get("PE 2 Pentaque")!=null){
						freSem2.getModel().setValueAt("PE 2 Pentaque",6,0);
						freSem2.getModel().setValueAt(courseSection.get("PE 2 Pentaque"),6,1);
						freSem2.getModel().setValueAt(courseGrade.get("PE 2 Pentaque"),6,2);
					}
					
					else if(courseSection.get("PE 2 Men's Basketball")!=null && courseGrade.get("PE 2 Men's Basketball")!=null){
						freSem2.getModel().setValueAt("PE 2 Men's Basketball",6,0);
						freSem2.getModel().setValueAt(courseSection.get("PE 2 Men's Basketball"),6,1);
						freSem2.getModel().setValueAt(courseGrade.get("PE 2 Men's Basketball"),6,2);
					}
					
					else if(courseSection.get("PE 2 Women's Basketball")!=null && courseGrade.get("PE 2 Women's Basketball")!=null){
						freSem2.getModel().setValueAt("PE 2 Women's Basketball",6,0);
						freSem2.getModel().setValueAt(courseSection.get("PE 2 Women's Basketball"),6,1);
						freSem2.getModel().setValueAt(courseGrade.get("PE 2 Women's Basketball"),6,2);
					}
					
					
					if(courseSection.get("CMSC 110")!=null && courseGrade.get("CMSC 110")!=null && CMSC12==true) {
						sopSem1.getModel().setValueAt(courseSection.get("CMSC 110"),0,1);
						sopSem1.getModel().setValueAt(courseGrade.get("CMSC 110"),0,2);
						Math55=true;
					}
					
					if(courseSection.get("CMSC 131")!=null && courseGrade.get("CMSC 131")!=null && CMSC12==true) {
						sopSem1.getModel().setValueAt(courseSection.get("CMSC 131"),1,1);
						sopSem1.getModel().setValueAt(courseGrade.get("CMSC 131"),1,2);
						CMSC131=true;
					}
					
					if(courseSection.get("Math 55")!=null && courseGrade.get("Math 55")!=null && Math54==true) {			//for CMSC 116
						sopSem1.getModel().setValueAt(courseSection.get("Math 55"),2,1);
						sopSem1.getModel().setValueAt(courseGrade.get("Math 55"),2,2);
						Math55=true;
					}
					
					if(courseSection.get("Physics 101")!=null && courseGrade.get("Physics 101")!=null) {
						sopSem1.getModel().setValueAt(courseSection.get("Physics 101"),3,1);
						sopSem1.getModel().setValueAt(courseGrade.get("Physics 101"),3,2);
						Physics101=true;
					}
					
					if(courseSection.get("Physics 101.1")!=null && courseGrade.get("Physics 101.1")!=null && Physics101==true) {
						sopSem1.getModel().setValueAt(courseSection.get("Physics 101.1"),4,1);
						sopSem1.getModel().setValueAt(courseGrade.get("Physics 101.1"),4,2);
					}
					
					if(courseSection.get("COMM 10")!=null && courseGrade.get("COMM 10")!=null) {
						sopSem1.getModel().setValueAt(courseSection.get("COMM 10"),5,1);
						sopSem1.getModel().setValueAt(courseGrade.get("COMM 10"),5,2);
					}
					
					//NSTP 1 CWTS
					
					if(courseSection.get("NSTP 1 CWTS")!=null && courseGrade.get("NSTP 1 CWTS")!=null) {
						sopSem1.getModel().setValueAt("NSTP 1 CWTS",7,0);
						sopSem1.getModel().setValueAt(courseSection.get("NSTP 1 CWTS"),7,1);
						sopSem1.getModel().setValueAt(courseGrade.get("NSTP 1 CWTS"),7,2);
					}
					
					else if(courseSection.get("NSTP 1 LTC")!=null && courseGrade.get("NSTP 1 LTC")!=null) {
						sopSem1.getModel().setValueAt("NSTP 1 LTC",7,0);
						sopSem1.getModel().setValueAt(courseSection.get("NSTP 1 LTC"),7,1);
						sopSem1.getModel().setValueAt(courseGrade.get("NSTP 1 LTC"),7,2);
					}
					
					else if(courseSection.get("NSTP 1 ROTC")!=null && courseGrade.get("NSTP 1 ROTC")!=null) {
						sopSem1.getModel().setValueAt("NSTP 1 ROTC",7,0);
						sopSem1.getModel().setValueAt(courseSection.get("NSTP 1 ROTC"),7,1);
						sopSem1.getModel().setValueAt(courseGrade.get("NSTP 1 ROTC"),7,2);
					}
					
					else if(courseSection.get("NSTP 1 ROTC")!=null && courseGrade.get("NSTP 1 ROTC")!=null) {
						sopSem1.getModel().setValueAt(courseSection.get("NSTP 1 ROTC"),7,1);
						sopSem1.getModel().setValueAt(courseGrade.get("NSTP 1 ROTC"),7,2);
					}
					
					
					
					if(courseSection.get("CMSC 116")!=null && courseGrade.get("CMSC 116")!=null && Math55==true) {
						sopSem2.getModel().setValueAt(courseSection.get("CMSC 116"),0,1);
						sopSem2.getModel().setValueAt(courseGrade.get("CMSC 116"),0,2);
						CMSC116=true;
					}
					if(courseSection.get("CMSC 123")!=null && courseGrade.get("CMSC 123")!=null && CMSC12==true && CMSC55==true) {			//for CMSC 124,125,127,128 and 	162
						sopSem2.getModel().setValueAt(courseSection.get("CMSC 123"),1,1);
						sopSem2.getModel().setValueAt(courseGrade.get("CMSC 123"),1,2);
						CMSC123=true;
					}
					
					if(courseSection.get("Physics 102")!=null && courseGrade.get("Physics 102")!=null && Physics101==true) {
						sopSem2.getModel().setValueAt(courseSection.get("Physics 102"),2,1);
						sopSem2.getModel().setValueAt(courseGrade.get("Physics 102"),2,2);
						Physics102=true;
					}
					
					if(courseSection.get("Physics 102.2")!=null && courseGrade.get("Physics 102.2")!=null && Physics102==true) {
						sopSem2.getModel().setValueAt(courseSection.get("Physics 103"),3,1);
						sopSem2.getModel().setValueAt(courseGrade.get("Physics 103"),3,2);
					}
					if(courseSection.get("SCIENCE 11")!=null && courseGrade.get("SCIENCE 11")!=null) {
						sopSem2.getModel().setValueAt(courseSection.get("SCIENCE 11"),4,1);
						sopSem2.getModel().setValueAt(courseGrade.get("SCIENCE 11"),4,2);
					}
					
					if(courseSection.get("KAS 1")!=null && courseGrade.get("KAS 1")!=null) {
						sopSem2.getModel().setValueAt(courseSection.get("SCIENCE 11"),5,1);
						sopSem2.getModel().setValueAt(courseGrade.get("SCIENCE 11"),5,2);
					}
					
					else if(courseSection.get("HIST I")!=null && courseGrade.get("HIST I")!=null) {
						sopSem2.getModel().setValueAt(courseSection.get("HIST I"),5,1);
						sopSem2.getModel().setValueAt(courseGrade.get("HIST I"),5,2);
					}
					
					else if(courseSection.get("NSTP 2 LTC")!=null && courseGrade.get("NSTP 2 LTC")!=null) {
						sopSem2.getModel().setValueAt("NSTP 1 LTC",7,0);
						sopSem2.getModel().setValueAt(courseSection.get("NSTP 2 LTC"),7,1);
						sopSem2.getModel().setValueAt(courseGrade.get("NSTP 2 LTC"),7,2);
					}
					
					else if(courseSection.get("NSTP 2 ROTC")!=null && courseGrade.get("NSTP 1 ROTC")!=null) {
						sopSem2.getModel().setValueAt("NSTP 1 ROTC",7,0);
						sopSem2.getModel().setValueAt(courseSection.get("NSTP 2 ROTC"),7,1);
						sopSem2.getModel().setValueAt(courseGrade.get("NSTP 2 ROTC"),7,2);
					}
					
					else if(courseSection.get("NSTP 2 CWTS")!=null && courseGrade.get("NSTP 1 ROTC")!=null) {
						sopSem2.getModel().setValueAt("NSTP 1 CWTS",7,0);
						sopSem2.getModel().setValueAt(courseSection.get("NSTP 1 CWTS"),7,1);
						sopSem2.getModel().setValueAt(courseGrade.get("NSTP 1 CWTS"),7,2);
					}
					
					if(courseSection.get("CMSC 117")!=null && courseGrade.get("CMSC 117")!=null && CMSC116==true) {
						junSem1.getModel().setValueAt(courseSection.get("CMSC 117"),0,1);
						junSem1.getModel().setValueAt(courseGrade.get("CMSC 117"),0,2);
					}
						
					if(courseSection.get("CMSC 124")!=null && courseGrade.get("CMSC 124")!=null && CMSC123==true) {
						junSem1.getModel().setValueAt(courseSection.get("CMSC 124"),1,1);
						junSem1.getModel().setValueAt(courseGrade.get("CMSC 124"),1,2);
					}
					
					if(courseSection.get("CMSC 127")!=null && courseGrade.get("CMSC 127")!=null && CMSC123==true) {
						junSem1.getModel().setValueAt(courseSection.get("CMSC 127"),2,1);
						junSem1.getModel().setValueAt(courseGrade.get("CMSC 127"),2,2);
					}
					
					String[] elective={"Interactive Computer Graphics","Artificial Intelligence","Special Topics","Practicum","Algebraic Structures I","Algebraic Structures I","Algebraic Structures I","Complex Analysis","Probability Theory","Mathematical Statistics","Applied Statistics","Foundations of Mathematics","Foundations of Mathematics","Foundations of Mathematics "};
					
					for(int i=0; i<elective.length;i++) {
						if(i==0 &&courseSection.get(elective[0])!=null && courseGrade.get(elective[0])!=null && CMSC116==true) {
						junSem1.getModel().setValueAt(elective[0],3,0);
						junSem1.getModel().setValueAt(courseSection.get(elective[0]),3,1);
						junSem1.getModel().setValueAt(courseGrade.get(elective[0]),3,2);
						}
						
						if(i==1 &&courseSection.get(elective[1])!=null && courseGrade.get(elective[1])!=null && CMSC123==true) {
							junSem1.getModel().setValueAt(elective[1],3,0);
							junSem1.getModel().setValueAt(courseSection.get(elective[1]),3,1);
							junSem1.getModel().setValueAt(courseGrade.get(elective[1]),3,2);
						}
						else if(i==2 &&courseSection.get(elective[2])!=null && courseGrade.get(elective[2])!=null) {
							junSem1.getModel().setValueAt(elective[2],3,0);
							junSem1.getModel().setValueAt(courseSection.get(elective[2]),3,1);
							junSem1.getModel().setValueAt(courseGrade.get(elective[2]),3,2);
						}
						else if(i==3 &&courseSection.get(elective[3])!=null && courseGrade.get(elective[3])!=null) {
							junSem1.getModel().setValueAt(elective[3],3,0);
							junSem1.getModel().setValueAt(courseSection.get(elective[3]),3,1);
							junSem1.getModel().setValueAt(courseGrade.get(elective[3]),3,2);
						}
						else if(i==4 &&courseSection.get(elective[4])!=null && courseGrade.get(elective[4])!=null && CMSC55==true) {
							junSem1.getModel().setValueAt(elective[4],3,0);
							junSem1.getModel().setValueAt(courseSection.get(elective[4]),3,1);
							junSem1.getModel().setValueAt(courseGrade.get(elective[4]),3,2);
						}
						else if(i==5 &&courseSection.get(elective[5])!=null && courseGrade.get(elective[5])!=null && CMSC55==true) {
							junSem1.getModel().setValueAt(elective[5],3,0);
							junSem1.getModel().setValueAt(courseSection.get(elective[5]),3,1);
							junSem1.getModel().setValueAt(courseGrade.get(elective[5]),3,2);
						}
						else if(i==6 &&courseSection.get(elective[6])!=null && courseGrade.get(elective[6])!=null && CMSC55==true && Math55==true) {
							junSem1.getModel().setValueAt(elective[6],3,0);
							junSem1.getModel().setValueAt(courseSection.get(elective[6]),3,1);
							junSem1.getModel().setValueAt(courseGrade.get(elective[6]),3,2);
						}
						else if(i==7 &&courseSection.get(elective[7])!=null && courseGrade.get(elective[7])!=null && Math55==true) {
							junSem1.getModel().setValueAt(elective[7],3,0);
							junSem1.getModel().setValueAt(courseSection.get(elective[7]),3,1);
							junSem1.getModel().setValueAt(courseGrade.get(elective[7]),3,2);
						}
						else if(i==8 &&courseSection.get(elective[8])!=null && courseGrade.get(elective[8])!=null) {
							junSem1.getModel().setValueAt(elective[8],3,0);
							junSem1.getModel().setValueAt(courseSection.get(elective[8]),3,1);
							junSem1.getModel().setValueAt(courseGrade.get(elective[8]),3,2);
						}
						else if(i==9 &&courseSection.get(elective[9])!=null && courseGrade.get(elective[9])!=null && Math55==true) {
							junSem1.getModel().setValueAt(elective[9],3,0);
							junSem1.getModel().setValueAt(courseSection.get(elective[9]),3,1);
							junSem1.getModel().setValueAt(courseGrade.get(elective[9]),3,2);
						}
						else if(i==10 &&courseSection.get(elective[10])!=null && courseGrade.get(elective[10])!=null) {
							junSem1.getModel().setValueAt(elective[10],3,0);
							junSem1.getModel().setValueAt(courseSection.get(elective[10]),3,1);
							junSem1.getModel().setValueAt(courseGrade.get(elective[10]),3,2);
						}
						else if(i==11 &&courseSection.get(elective[11])!=null && courseGrade.get(elective[11])!=null && CMSC55==true) {
							junSem1.getModel().setValueAt(elective[11],3,0);
							junSem1.getModel().setValueAt(courseSection.get(elective[11]),3,1);
							junSem1.getModel().setValueAt(courseGrade.get(elective[11]),3,2);
						}
						else if(i==12 &&courseSection.get(elective[12])!=null && courseGrade.get(elective[12])!=null && CMSC116==true) {
							junSem1.getModel().setValueAt(elective[12],3,0);
							junSem1.getModel().setValueAt(courseSection.get(elective[12]),3,1);
							junSem1.getModel().setValueAt(courseGrade.get(elective[12]),3,2);
						}
						else if(i==13 &&courseSection.get(elective[13])!=null && courseGrade.get(elective[13])!=null) {
							junSem1.getModel().setValueAt(elective[13],3,0);
							junSem1.getModel().setValueAt(courseSection.get(elective[13]),3,1);
							junSem1.getModel().setValueAt(courseGrade.get(elective[13]),3,2);
						}
						if(courseSection.get("Wika 1")!=null && courseGrade.get("Wika 1")!=null) {
							junSem1.getModel().setValueAt(courseSection.get("Wika 1"),4,1);
							junSem1.getModel().setValueAt(courseGrade.get("Wika 1"),4,2);
						}
						if(courseSection.get("STS 1")!=null && courseGrade.get("STS 1")!=null) {
							junSem1.getModel().setValueAt(courseSection.get("STS 1"),4,1);
							junSem1.getModel().setValueAt(courseGrade.get("STS 1"),4,2);
						}
						
						if(courseSection.get("CMSC 125")!=null && courseGrade.get("CMSC 125")!=null && CMSC123==true && CMSC131==true) {
							junSem2.getModel().setValueAt(courseSection.get("CMSC 125"),0,1);
							junSem2.getModel().setValueAt(courseGrade.get("CMSC 125"),0,2);
							CMSC125=true;
						}
						
						if(courseSection.get("CMSC 128")!=null && courseGrade.get("CMSC 128")!=null && CMSC123==true) {
							junSem2.getModel().setValueAt(courseSection.get("CMSC 128"),1,1);
							junSem2.getModel().setValueAt(courseGrade.get("CMSC 128"),1,2);
						}
						if(courseSection.get("CMSC 141")!=null && courseGrade.get("CMSC 141")!=null && CMSC55==true) {
							junSem2.getModel().setValueAt(courseSection.get("CMSC 141"),2,1);
							junSem2.getModel().setValueAt(courseGrade.get("CMSC 141"),2,2);
						}
						if(courseSection.get("CMSC 199")!=null && courseGrade.get("CMSC 199")!=null) {
							junSem2.getModel().setValueAt(courseSection.get("CMSC 199"),3,1);
							junSem2.getModel().setValueAt(courseGrade.get("CMSC 199"),3,2);
						}
						if(courseSection.get("FA 101")!=null && courseGrade.get("FA 101")!=null) {
							junSem2.getModel().setValueAt(courseSection.get("FA 101"),5,1);
							junSem2.getModel().setValueAt(courseGrade.get("FA 101"),5,2);
						}
						
						
						if(courseSection.get("CMSC 135")!=null && courseGrade.get("CMSC 135")!=null && CMSC125==true) {
							senSem1.getModel().setValueAt(courseSection.get("CMSC 135"),0,1);
							senSem1.getModel().setValueAt(courseGrade.get("CMSC 135"),0,2);
						}
						if(courseSection.get("CMSC 142")!=null && courseGrade.get("CMSC 142")!=null&& CMSC123==true) {
							senSem1.getModel().setValueAt(courseSection.get("CMSC 142"),1,1);
							senSem1.getModel().setValueAt(courseGrade.get("CMSC 142"),1,2);
						}
						if(courseSection.get("CMSC 190")!=null && courseGrade.get("CMSC 190")!=null) {
							senSem1.getModel().setValueAt(courseSection.get("CMSC 190"),2,1);
							senSem1.getModel().setValueAt(courseGrade.get("CMSC 190"),2,2);
						}
						if(courseSection.get("SAS 101")!=null && courseGrade.get("SAS 101")!=null) {
							senSem1.getModel().setValueAt(courseSection.get("SAS 101"),3,1);
							senSem2.getModel().setValueAt(courseGrade.get("SAS 101"),3,2);
						}
						if(courseSection.get("PI 100")!=null && courseGrade.get("PI 100")!=null) {
							senSem1.getModel().setValueAt(courseSection.get("PI 100"),5,1);
							senSem1.getModel().setValueAt(courseGrade.get("PI 100"),5,2);
						}
						if(courseSection.get("CMSC 190")!=null && courseGrade.get("CMSC 190")!=null) {
							senSem2.getModel().setValueAt(courseSection.get("CMSC 190"),0,1);
							senSem2.getModel().setValueAt(courseGrade.get("CMSC 190"),0,2);
						}
					}
				}
			}
		});
		
		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				JFileChooser save = new JFileChooser();
				save.setDialogTitle("Choose a directory and name the file with (.txt): ");
				int option = save.showSaveDialog(null);
				save.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				fileToSave = option;
				fileSave = save;
				if (fileToSave == JFileChooser.APPROVE_OPTION && loadAct==true) {
					try {
						File file = new File(fileSave.getSelectedFile().getPath());
						FileWriter out = new FileWriter(file);
						String result0 = Arrays.stream(getTableData(freSem1)).map(Arrays::toString) .collect(Collectors.joining("\n")).replaceAll("\\[","").replaceAll("\\]","");
						String result1 = Arrays.stream(getTableData(freSem2)).map(Arrays::toString) .collect(Collectors.joining("\n")).replaceAll("\\[","").replaceAll("\\]","");
						String result2 = Arrays.stream(getTableData(sopSem1)).map(Arrays::toString) .collect(Collectors.joining("\n")).replaceAll("\\[","").replaceAll("\\]","");
						String result3 = Arrays.stream(getTableData(sopSem2)).map(Arrays::toString) .collect(Collectors.joining("\n")).replaceAll("\\[","").replaceAll("\\]","");
						String result4 = Arrays.stream(getTableData(junSem1)).map(Arrays::toString) .collect(Collectors.joining("\n")).replaceAll("\\[","").replaceAll("\\]","");
						String result5 = Arrays.stream(getTableData(junSem2)).map(Arrays::toString) .collect(Collectors.joining("\n")).replaceAll("\\[","").replaceAll("\\]","");
						String result6 = Arrays.stream(getTableData(senSem1)).map(Arrays::toString) .collect(Collectors.joining("\n")).replaceAll("\\[","").replaceAll("\\]","");
						String result7 = Arrays.stream(getTableData(senSem2)).map(Arrays::toString) .collect(Collectors.joining("\n")).replaceAll("\\[","").replaceAll("\\]","");
						String bigString =textFieldID.getText()+"\n"+textFieldName.getText()+"\n"+result0+"\n"+result1+"\n"+result2+"\n"+result3+"\n"+result4+"\n"+result5+"\n"+result6+"\n"+result7;
						out.write(bigString);
						out.close();
					}
					catch (IOException ex) {
						System.out.println(ex.getMessage());
					}
				}
				else if(loadAct==false) {
					JFrame notice=new JFrame();
					JOptionPane.showMessageDialog(notice,"Please open a valid text file.","Notice",JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		
		close.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
	
		freSem1 = new JTable();
		freSem1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		freSem1.setModel(new DefaultTableModel(
			fir1=new Object[][] {
				{"Course", "Section", "Grade"},
				{"CMSC 11", null, null},
				{"Math 53", null, null},
				{"Math 101", null, null},
				{"Arts 1", null, null},
				{"PE 1", null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Course", "Section", "Grade"
			}
		));
		freSem1.getColumnModel().getColumn(0).setPreferredWidth(250);
		
		
		freSem1.setBorder(new LineBorder(Color.GRAY, 1));
		freSem1.setBounds(80, 67, 295, 128);
		frame.getContentPane().add(freSem1);
		
		freSem2 = 	new JTable();
		freSem2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		freSem2.setModel(new DefaultTableModel(
			fir2=new Object[][] {
				{"Course", "Section", "Grade"},
				{"CMSC 12", null, null},
				{"CMSC 55", null, null},
				{"CMSC 130", null, null},
				{"Math 54", null, null},
				{"Ethics 1", null, null},
				{"PE 2 ", null, null},
				{null, null, null},
			},
			new String[] {
				"Course", "Section", "Grade"
			}
		));
		freSem2.getColumnModel().getColumn(0).setPreferredWidth(250);
		freSem2.setBorder(new LineBorder(Color.GRAY, 1));
		freSem2.setBounds(435, 67, 295, 128);
		frame.getContentPane().add(freSem2);
		
		sopSem1 = new JTable();
		sopSem1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		sopSem1.setModel(new DefaultTableModel(
			sec1=new Object[][] {
				{"CMSC 110", null, null},
				{"CMSC 131", null, null},
				{"Math 55", null, null},
				{"Physics 101", null, null},
				{"Physics 101.1", null, null},
				{"COMM 10", null, null},
				{"PE 2 Phy Ed activities", null, null},
				{"NSTP 1 CWTS", null, null},
			},
			new String[] {
				"Course", "Section", "Grade"
			}
		));
		sopSem1.getColumnModel().getColumn(0).setPreferredWidth(250);
		
		
		sopSem1.setBorder(new LineBorder(Color.GRAY, 1));
		sopSem1.setBounds(80, 234, 295, 128);
		frame.getContentPane().add(sopSem1);
		
		sopSem2 = new JTable();
		sopSem2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		sopSem2.setModel(new DefaultTableModel(
			sec2=new Object[][] {
				{"CMSC 116", null, null},
				{"CMSC 123", null, null},
				{"Physics 102", null, null},
				{"Physics 102.1", null, null},
				{"SCIENCE 11", null, null},
				{"KAS 1/HIST I", null, null},
				{"PE 2 ", null, null},
				{"NSTP 2", null, null},
			},
			new String[] {
				"Course", "Section", "Grade"
			}
		));
		sopSem2.getColumnModel().getColumn(0).setPreferredWidth(250);
		sopSem2.setBorder(new LineBorder(Color.GRAY, 1));
		sopSem2.setBounds(435, 234, 295, 128);
		frame.getContentPane().add(sopSem2);
		
		junSem1 = new JTable();
		junSem1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		junSem1.setModel(new DefaultTableModel(
			thi1=new Object[][] {
				{"CMSC 117", null, null},
				{"CMSC 124", null, null},
				{"CMSC 127", null, null},
				{"CMSC/Math Elective 1", null, null},
				{"Wika 1", null, null},
				{"STS 1", null, null},
				{null, null, null},
			},
			new String[] {
				"Course", "Section", "Grade"
			}
		));
		junSem1.getColumnModel().getColumn(0).setPreferredWidth(250);
		
		
		junSem1.setBorder(new LineBorder(Color.GRAY, 1));
		junSem1.setBounds(80, 404, 295, 128);
		frame.getContentPane().add(junSem1);
		
		junSem2 = new JTable();
		junSem2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		junSem2.setModel(new DefaultTableModel(
			thi2=new Object[][] {
				{"CMSC 125", null, null},
				{"CMSC 128", null, null},
				{"CMSC 141", null, null},
				{"CMSC 199", null, null},
				{"CMSC/Math Elective 2", null, null},
				{"FA 101", null, null},
				{null, null, null},
			},
			new String[] {
				"Course", "Section", "Grade"
			}
		));
		junSem2.getColumnModel().getColumn(0).setPreferredWidth(250);
		junSem2.setBorder(new LineBorder(Color.GRAY, 1));
		junSem2.setBounds(435, 404, 295, 128);
		frame.getContentPane().add(junSem2);
		
		senSem1 = new JTable();
		senSem1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		senSem1.setModel(new DefaultTableModel(
			fou1=new Object[][] {
				{"CMSC 135", null, null},
				{"CMSC 142", null, null},
				{"CMSC 190", null, null},
				{"SAS 1", null, null},
				{"Free Elective 2", null, null},
				{"PI 100", null, null},
				{null, null, null},
			},
			new String[] {
				"Course", "Section", "Grade"
			}
		));
		senSem1.getColumnModel().getColumn(0).setPreferredWidth(250);
		senSem1.setBorder(new LineBorder(Color.GRAY, 1));
		senSem1.setBounds(80, 578, 295, 128);
		frame.getContentPane().add(senSem1);
		
		senSem2 = new JTable();
		senSem2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		senSem2.setModel(new DefaultTableModel(
			fou2=new Object[][] {
				{"CMSC 190", null, null},
				{"AH GE 4 (Elective)", null, null},
				{"NSM GE 4(Elective)", null, null},
				{"SSP GE 4 (Elective)", null, null},
				{"CMSC/Math Elective 3", null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Course", "Section", "Grade"
			}
		));
		senSem2.getColumnModel().getColumn(0).setPreferredWidth(250);
		senSem2.setBorder(new LineBorder(Color.GRAY, 1));
		senSem2.setBounds(435, 578, 295, 128);
		frame.getContentPane().add(senSem2);
		
		lblFirstYear = new JLabel("<html>F<br>I<br>R<br>S<br>T<br><br>Y<br>R</html>");
		lblFirstYear.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblFirstYear.setBounds(51, 67, 16, 128);
		frame.getContentPane().add(lblFirstYear);
		
		lblSecondYear = new JLabel("<html>S<br>E<br>C<br>O<br>N<br>D<br><br>Y<br>R</html>");
		lblSecondYear.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblSecondYear.setBounds(51, 234, 16, 128);
		frame.getContentPane().add(lblSecondYear);
		
		lblThirdYear = new JLabel("<html>T<br>H<br>I<br>R<br>D<br><br>Y<br>R</html>");
		lblThirdYear.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblThirdYear.setBounds(51, 404, 16, 128);
		frame.getContentPane().add(lblThirdYear);
		
		lblFourthYear = new JLabel("<html>F<br>O<br>U<br>R<br>T<br>H<br><br>Y<br>R</html>");
		lblFourthYear.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblFourthYear.setBounds(51, 578, 16, 128);
		frame.getContentPane().add(lblFourthYear);
		
		lblFirstSemester = new JLabel("First Semester");
		lblFirstSemester.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblFirstSemester.setBounds(80, 42, 102, 14);
		frame.getContentPane().add(lblFirstSemester);
		
		lblSecondSemester = new JLabel("Second Semester");
		lblSecondSemester.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblSecondSemester.setBounds(435, 42, 124, 14);
		frame.getContentPane().add(lblSecondSemester);
		
		lblStudentName = new JLabel("Student Name:");
		lblStudentName.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblStudentName.setBounds(80, 11, 90, 14);
		frame.getContentPane().add(lblStudentName);
		
		lblNewLabel_3 = new JLabel("Student ID:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_3.setBounds(435, 11, 72, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Times New Roman", Font.BOLD, 13));
		textFieldName.setBounds(165, 8, 210, 20);
		frame.getContentPane().add(textFieldName);
		textFieldName.setEditable(true);
		
		textFieldName.setColumns(10);
		
		textFieldID = new JTextField();
		textFieldID.setFont(new Font("Times New Roman", Font.BOLD, 13));
		textFieldID.setColumns(10);
		textFieldID.setEditable(true);
		textFieldID.setBounds(520, 8, 210, 20);
		frame.getContentPane().add(textFieldID);
	}
	
	public Object[][] getTableData (JTable table) {
		DefaultTableModel getTableMod = (DefaultTableModel) table.getModel();
		int numRow = getTableMod.getRowCount(), numCol = getTableMod.getColumnCount();
		Object[][] tableData = new Object[numRow][numCol];
		for (int i = 0 ; i < numRow ; i++)
			for (int j = 0 ; j < numCol ; j++)
				tableData[i][j] = getTableMod.getValueAt(i,j);
		return tableData;
	}

}


//known bugs=JTables last row does not appear until clicked, same applies to PE 2 at freSem2 when the data is loaded. PE is not properly executed.