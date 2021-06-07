import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;

public class Mouse extends MouseAdapter implements MouseListener{

	int getx;
	int gety;
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		getx=e.getX();
		gety=e.getY();
		
	if(GamePlay.state==GamePlay.State.MENU)
	{
		     //play button
				if(getx>=280 && getx <= 380)
				{
					if(gety >= 100 && gety<= 150)
					{
						//pressed play button
						GamePlay.state=GamePlay.State.GAME;
					}
				}
				
				//scoresButton
				if(getx>=280 && getx<= 380)
				{
					if(gety>=240 && gety<=290)
					{
						GamePlay.state=GamePlay.State.SCORES;
					}
				}
				//about button
				if(getx>=280 && getx<=380)
				{
					if(gety>=380 && gety<=430)
					{
						GamePlay.state=GamePlay.State.ABOUT;
					}
				}
				//help button
				if(getx>=280 && getx <= 380)
				{
					if(gety >= 310 && gety<= 360)
					{
						GamePlay.state=GamePlay.State.HELP;
						
					}
				}
				
				//options Button
				if(getx >=280 && getx<= 380)
				{
					if(gety>=170 && gety<=220)
					{
						//pressed goback button
						GamePlay.state=GamePlay.State.OPTIONS;
					
						
					}
				}
				
				
				//quit button
				if(getx>=280 && getx <= 380)
				{
					if(gety >= 450 && gety<= 500)
					{
						//pressed quit button
						GamePlay.state=GamePlay.State.GAME;
						System.exit(1);
					}
				}
			
	}
		
		if(GamePlay.state==GamePlay.State.HELP || GamePlay.state==GamePlay.State.OPTIONS ||GamePlay.state==GamePlay.State.ABOUT ||GamePlay.state==GamePlay.State.SCORES)
		{
			if(getx >=270 && getx<= 395)
			{
				if(gety>=490 && gety<=530)
				{
					//pressed goback button
					GamePlay.state=GamePlay.State.MENU;
				}
			}
			
		}	
		
		if(GamePlay.state==GamePlay.State.OPTIONS)
		{
		
			//Level1 button
			if(getx>=280 && getx <= 380)
			{
				if(gety >= 240 && gety<= 290)
				{
					//pressed LEVEL1 button
					GamePlay.state=GamePlay.State.LEVEL1;
					
				}
			}
			//LEVEL2 BUTTON
			if(getx>=280 && getx <= 380)
			{
				if(gety >= 300 && gety<= 350)
				{
					//pressed LEVEL2 button
					GamePlay.state=GamePlay.State.LEVEL2;
					
				}
			}	
			//LEVEL3 BUTTON
			if(getx>=280 && getx <= 380)
			{
				if(gety >= 360 && gety<= 410)
				{
					//pressed LEVEL3 button
					GamePlay.state=GamePlay.State.LEVEL3;
					
					
				}
			}
		}
		
		
	}
		


}
