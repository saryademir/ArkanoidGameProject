
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Testing {
	
	public static void main(String args[]) throws IOException
	{

		JFrame obj=new JFrame();
	
		obj.setBounds(400, 100,700, 600);
		GamePlay gamePlay = new GamePlay();
		
		obj.setTitle("ARKANOID GAME WINDOW");
		obj.setResizable(false);
		obj.setOpacity(1);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		obj.add(gamePlay);
		
	
		
	


	}
}
