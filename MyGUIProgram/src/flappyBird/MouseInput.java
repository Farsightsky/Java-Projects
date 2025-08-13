package flappyBird;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (FlappyBird.State==FlappyBird.STATE.MENU) {
		int mouseX=e.getX();
		int mouseY=e.getY();
			if(mouseX >= FlappyBird.WIDTH/2-80 && mouseX <= FlappyBird.WIDTH/2+70) {
				if(mouseY>=290&&mouseY<=360) {
					FlappyBird.State = FlappyBird.STATE.GAME;
				}
				else if(mouseY>=390 && mouseY <= 460) {
					System.exit(0);
				}
			}
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
	
	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

}
