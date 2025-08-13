package Notepadish;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class helper extends JFrame{

	private static final long serialVersionUID = 1L;

	JFrame notice;
	static JTextArea stats = new JTextArea();
	static helper window =  new helper();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	helper() {
		getContentPane().add(stats);
		stats.setLineWrap(true);
		stats.setWrapStyleWord(true);
		stats.setText("-Number of sentences: "+Grid.sentenceCount+"\n\n-Number of characters: "+Grid.letterCount +"\n\n"
					+ "-Number of words: "+Grid.wordCount+"\n\n"
					+"-Character frequency\n\n"+Grid.charFrequency +"\n\n-Word frequency: \n"
					+Grid.wordFrequency+"\n\n-Sorted Words;\n\n"+Grid.sortedWords);
		stats.setEditable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
	int wordcount = 0;

}
	