package flappyBird;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Menu {
	public Rectangle playButton = new Rectangle(FlappyBird.WIDTH/2-90, 300, 150, 50);
	public Rectangle quitButton = new Rectangle(FlappyBird.WIDTH/2-90, 400, 150, 50);
	public void render(Graphics g) {
		g.setColor(Color.cyan.darker().darker().darker().darker().darker().darker().darker());
		g.fillRect(0, 0, FlappyBird.WIDTH, FlappyBird.HEIGHT);
		Graphics2D menuButton =(Graphics2D) g;
		Font font0 = new Font("arial", Font.BOLD,50);
		g.setFont(font0);
		g.setColor(Color.white);
		g.drawString("Flappy Bird", FlappyBird.WIDTH/2-150, 100);
		Font font1 = new Font("arial", Font.BOLD,30);
		g.setFont(font1); 
		g.setColor(Color.white);
		g.drawString("Start", playButton.x+40, playButton.y+35);
		menuButton.draw(playButton);
		g.setFont(font1);
		g.setColor(Color.white);
		g.drawString("Quit", quitButton.x+45, quitButton.y+35);
		menuButton.draw(quitButton);
	} 
}
