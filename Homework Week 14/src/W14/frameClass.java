package W14;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class frameClass {
	public static void main(String args[]){
		JFrame frame1 = new Grid();
		JScrollPane yScroll=new JScrollPane(Grid.textArea);
		frame1.add(yScroll);
		frame1.setTitle("Text Value");
		frame1.setVisible(true);
		frame1.setSize(1280, 720);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setResizable(true);
		frame1.setLocationRelativeTo(null);
	}
}
